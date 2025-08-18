package com.marcos.quizapplication.di;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.marcos.quizapplication.domain.contracts.AuthRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class AuthModule_ProvideAuthRepositoryFactory implements Factory<AuthRepository> {
  private final Provider<FirebaseAuth> firebaseAuthProvider;

  private final Provider<FirebaseFirestore> firestoreProvider;

  private final Provider<FirebaseStorage> storageProvider;

  public AuthModule_ProvideAuthRepositoryFactory(Provider<FirebaseAuth> firebaseAuthProvider,
      Provider<FirebaseFirestore> firestoreProvider, Provider<FirebaseStorage> storageProvider) {
    this.firebaseAuthProvider = firebaseAuthProvider;
    this.firestoreProvider = firestoreProvider;
    this.storageProvider = storageProvider;
  }

  @Override
  public AuthRepository get() {
    return provideAuthRepository(firebaseAuthProvider.get(), firestoreProvider.get(), storageProvider.get());
  }

  public static AuthModule_ProvideAuthRepositoryFactory create(
      Provider<FirebaseAuth> firebaseAuthProvider, Provider<FirebaseFirestore> firestoreProvider,
      Provider<FirebaseStorage> storageProvider) {
    return new AuthModule_ProvideAuthRepositoryFactory(firebaseAuthProvider, firestoreProvider, storageProvider);
  }

  public static AuthRepository provideAuthRepository(FirebaseAuth firebaseAuth,
      FirebaseFirestore firestore, FirebaseStorage storage) {
    return Preconditions.checkNotNullFromProvides(AuthModule.INSTANCE.provideAuthRepository(firebaseAuth, firestore, storage));
  }
}
