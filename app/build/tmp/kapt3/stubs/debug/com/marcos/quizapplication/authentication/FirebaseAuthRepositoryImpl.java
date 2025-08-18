package com.marcos.quizapplication.authentication;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0012H\u0016J4\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cJ$\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u001e\u001a\u00020\u0014H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001f\u0010 J \u0010!\u001a\u00020\"*\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u00142\b\u0010%\u001a\u0004\u0018\u00010\u0014H\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006&"}, d2 = {"Lcom/marcos/quizapplication/authentication/FirebaseAuthRepositoryImpl;", "Lcom/marcos/quizapplication/domain/contracts/AuthRepository;", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "storage", "Lcom/google/firebase/storage/FirebaseStorage;", "(Lcom/google/firebase/auth/FirebaseAuth;Lcom/google/firebase/firestore/FirebaseFirestore;Lcom/google/firebase/storage/FirebaseStorage;)V", "_authState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/marcos/quizapplication/domain/contracts/AuthState;", "authState", "Lkotlinx/coroutines/flow/StateFlow;", "getAuthState", "()Lkotlinx/coroutines/flow/StateFlow;", "signIn", "Lkotlin/Result;", "", "email", "", "password", "signIn-0E7RQCE", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "signUp", "username", "signUp-BWLJW6A", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateProfilePicture", "imageUriString", "updateProfilePicture-gIAlu-s", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDomainUser", "Lcom/marcos/quizapplication/domain/model/User;", "Lcom/google/firebase/auth/FirebaseUser;", "usernameFromFirestore", "photoUrlFromFirestore", "app_debug"})
public final class FirebaseAuthRepositoryImpl implements com.marcos.quizapplication.domain.contracts.AuthRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.storage.FirebaseStorage storage = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.marcos.quizapplication.domain.contracts.AuthState> _authState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.marcos.quizapplication.domain.contracts.AuthState> authState = null;
    
    @javax.inject.Inject()
    public FirebaseAuthRepositoryImpl(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseAuth auth, @org.jetbrains.annotations.NotNull()
    com.google.firebase.firestore.FirebaseFirestore firestore, @org.jetbrains.annotations.NotNull()
    com.google.firebase.storage.FirebaseStorage storage) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.StateFlow<com.marcos.quizapplication.domain.contracts.AuthState> getAuthState() {
        return null;
    }
    
    @java.lang.Override()
    public void signOut() {
    }
    
    private final com.marcos.quizapplication.domain.model.User toDomainUser(com.google.firebase.auth.FirebaseUser $this$toDomainUser, java.lang.String usernameFromFirestore, java.lang.String photoUrlFromFirestore) {
        return null;
    }
}