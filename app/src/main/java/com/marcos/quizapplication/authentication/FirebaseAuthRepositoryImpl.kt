package com.marcos.quizapplication.authentication

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.FirebaseUser
import com.marcos.quizapplication.domain.contracts.AuthRepository
import com.marcos.quizapplication.domain.contracts.AuthState
import com.marcos.quizapplication.domain.contracts.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepositoryImpl(
    private val firebaseAuth: FirebaseAuth
) : AuthRepository {

    private val _authState = MutableStateFlow(AuthState())

    init {
        firebaseAuth.addAuthStateListener { auth ->
            _authState.update {
                it.copy(
                    user = auth.currentUser?.toDomainUser(),
                    isInitialLoading = false
                )
            }
        }
    }

    override fun getAuthState(): StateFlow<AuthState> = _authState.asStateFlow()

    /*override suspend fun signUp(email: String, password: String): Result<Unit> {
        return try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }*/
    override suspend fun signUp(email: String, password: String): Result<Unit> {
        return try {
            firebaseAuth.createUserWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: FirebaseAuthUserCollisionException) {
            // Email já em uso
            Log.w("FirebaseAuthRepo", "Sign up failed: Email already in use.", e)
            Result.failure(Exception("The email address is already in use by another account."))
        } catch (e: FirebaseAuthWeakPasswordException) {
            // Senha fraca
            Log.w("FirebaseAuthRepo", "Sign up failed: Weak password.", e)
            Result.failure(Exception("The password is too weak. It should be at least 6 characters."))
        } catch (e: Exception) {
            // Outras exceções (problemas de rede, etc.)
            Log.e("FirebaseAuthRepo", "Sign up failed: Unknown error.", e)
            Result.failure(Exception("An unexpected error occurred during sign up. Please try again."))
        }
    }

    override suspend fun signIn(email: String, password: String): Result<Unit> {
        return try {
            firebaseAuth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun signOut() {
        firebaseAuth.signOut()
    }
}

private fun FirebaseUser.toDomainUser(): User {
    return User(
        uid = this.uid,
        email = this.email
    )
}