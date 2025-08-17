package com.marcos.quizapplication.di;

import com.google.firebase.firestore.FirebaseFirestore;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class AuthModule_ProvideFirebaseFirestoreFactory implements Factory<FirebaseFirestore> {
  @Override
  public FirebaseFirestore get() {
    return provideFirebaseFirestore();
  }

  public static AuthModule_ProvideFirebaseFirestoreFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FirebaseFirestore provideFirebaseFirestore() {
    return Preconditions.checkNotNullFromProvides(AuthModule.INSTANCE.provideFirebaseFirestore());
  }

  private static final class InstanceHolder {
    private static final AuthModule_ProvideFirebaseFirestoreFactory INSTANCE = new AuthModule_ProvideFirebaseFirestoreFactory();
  }
}
