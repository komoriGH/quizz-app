package com.marcos.quizapplication.authentication;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class FirebaseAuthRepositoryImpl_Factory implements Factory<FirebaseAuthRepositoryImpl> {
  private final Provider<FirebaseAuth> authProvider;

  private final Provider<FirebaseFirestore> firestoreProvider;

  private final Provider<FirebaseStorage> storageProvider;

  public FirebaseAuthRepositoryImpl_Factory(Provider<FirebaseAuth> authProvider,
      Provider<FirebaseFirestore> firestoreProvider, Provider<FirebaseStorage> storageProvider) {
    this.authProvider = authProvider;
    this.firestoreProvider = firestoreProvider;
    this.storageProvider = storageProvider;
  }

  @Override
  public FirebaseAuthRepositoryImpl get() {
    return newInstance(authProvider.get(), firestoreProvider.get(), storageProvider.get());
  }

  public static FirebaseAuthRepositoryImpl_Factory create(Provider<FirebaseAuth> authProvider,
      Provider<FirebaseFirestore> firestoreProvider, Provider<FirebaseStorage> storageProvider) {
    return new FirebaseAuthRepositoryImpl_Factory(authProvider, firestoreProvider, storageProvider);
  }

  public static FirebaseAuthRepositoryImpl newInstance(FirebaseAuth auth,
      FirebaseFirestore firestore, FirebaseStorage storage) {
    return new FirebaseAuthRepositoryImpl(auth, firestore, storage);
  }
}
