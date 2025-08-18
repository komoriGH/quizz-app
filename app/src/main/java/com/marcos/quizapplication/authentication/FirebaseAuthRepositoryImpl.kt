package com.marcos.quizapplication.authentication

import android.net.Uri
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.UserProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.marcos.quizapplication.domain.contracts.AuthRepository
import com.marcos.quizapplication.domain.contracts.AuthState
import com.marcos.quizapplication.domain.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseAuthRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
    private val storage: FirebaseStorage
) : AuthRepository {

    private val _authState = MutableStateFlow<AuthState>(AuthState.InitialLoading)
    override val authState: StateFlow<AuthState> = _authState.asStateFlow()

    init {
        auth.addAuthStateListener { firebaseAuth ->
            val firebaseUser = firebaseAuth.currentUser
            if (firebaseUser == null) {
                _authState.value = AuthState.Unauthenticated
            } else {
                // Usuário logado, buscar dados do Firestore.
                // Considerar emitir um AuthState.Loading aqui se a operação for longa
                firestore.collection("users").document(firebaseUser.uid).get()
                    .addOnSuccessListener { documentSnapshot ->
                        if (documentSnapshot.exists()) {
                            val user = firebaseUser.toDomainUser(
                                usernameFromFirestore = documentSnapshot.getString("username"),
                                photoUrlFromFirestore = documentSnapshot.getString("photoUrl")
                            )
                            _authState.value = AuthState.Authenticated(user)
                        } else {
                            // Usuário autenticado no Firebase, mas sem registro no Firestore.
                            // Isso pode ser um estado de erro ou um usuário parcialmente configurado.
                            _authState.value = AuthState.Error("User data not found in Firestore for UID: ${firebaseUser.uid}. Please complete sign up or contact support.")
                        }
                    }
                    .addOnFailureListener { exception ->
                        _authState.value = AuthState.Error("Failed to fetch user data: ${exception.message}")
                    }
            }
        }
    }

    override suspend fun signUp(username: String, email: String, password: String): Result<Unit> {
        return try {
            val authResult = auth.createUserWithEmailAndPassword(email, password).await()
            val firebaseUser = authResult.user
            if (firebaseUser != null) {
                // Inicialmente sem photoUrl, será null
                val user = User(uid = firebaseUser.uid, email = email, username = username, photoUrl = null)
                firestore.collection("users").document(firebaseUser.uid).set(user).await()
                // O listener de authState irá capturar o novo usuário e emitir AuthState.Authenticated
                Result.success(Unit)
            } else {
                Result.failure(Exception("Firebase user is null after sign up."))
            }
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun signIn(email: String, password: String): Result<Unit> {
        return try {
            auth.signInWithEmailAndPassword(email, password).await()
            // O listener de authState irá capturar o login e emitir o estado apropriado
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun signOut() {
        auth.signOut()
        // O listener de authState irá capturar o logout e emitir AuthState.Unauthenticated
    }

    override suspend fun updateProfilePicture(imageUriString: String): Result<Unit> {
        return try {
            val currentUser = auth.currentUser
                ?: return Result.failure(Exception("User not authenticated to update profile picture."))

            val imageUri = Uri.parse(imageUriString)
            val profileImageRef = storage.reference.child("profile_pictures/${currentUser.uid}/profile_image.jpg")

            profileImageRef.putFile(imageUri).await()
            val downloadUrl = profileImageRef.downloadUrl.await().toString()

            val profileUpdates = UserProfileChangeRequest.Builder()
                .setPhotoUri(Uri.parse(downloadUrl))
                .build()
            currentUser.updateProfile(profileUpdates).await()

            firestore.collection("users").document(currentUser.uid)
                .update("photoUrl", downloadUrl)
                .await()
            
            // O listener de authState (no init) deve ser notificado sobre a mudança no currentUser
            // (se o photoURL do FirebaseUser for atualizado e observado) e/ou
            // uma nova busca no Firestore pegaria a photoUrl atualizada se o estado fosse reavaliado.
            // Para garantir que o usuário em AuthState.Authenticated seja o mais recente
            // após esta operação específica, podemos atualizar o valor explicitamente,
            // mas isso pode causar uma emissão duplicada se o listener também pegar.
            // A forma mais reativa é deixar o listener principal lidar com isso.
            // Se houver problemas com a atualização da UI, podemos forçar aqui:
            // val updatedUser = currentUser.toDomainUser(
            //     usernameFromFirestore = (_authState.value as? AuthState.Authenticated)?.user?.username,
            //     photoUrlFromFirestore = downloadUrl
            // )
            // _authState.value = AuthState.Authenticated(updatedUser)

            Result.success(Unit)
        } catch (e: Exception)
        {
            Result.failure(e)
        }
    }

    // Função de extensão para converter FirebaseUser para o modelo de domínio User
    // Mantém a lógica de priorizar dados do Firestore se disponíveis.
    private fun FirebaseUser.toDomainUser(usernameFromFirestore: String?, photoUrlFromFirestore: String?): User {
        return User(
            uid = this.uid,
            email = this.email, // Email do Firebase Auth é geralmente confiável
            username = usernameFromFirestore ?: this.displayName ?: "N/A", // Prioriza Firestore, depois Firebase Auth displayName
            photoUrl = photoUrlFromFirestore ?: this.photoUrl?.toString() // Prioriza Firestore, depois Firebase Auth photo URL
        )
    }
}
