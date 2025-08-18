package com.marcos.quizapplication.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage // Importação Adicionada
import com.marcos.quizapplication.authentication.FirebaseAuthRepositoryImpl
import com.marcos.quizapplication.domain.contracts.AuthRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth = FirebaseAuth.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseFirestore(): FirebaseFirestore = FirebaseFirestore.getInstance()

    @Provides
    @Singleton
    fun provideFirebaseStorage(): FirebaseStorage = FirebaseStorage.getInstance() // Novo provedor adicionado

    @Provides
    @Singleton
    fun provideAuthRepository(
        firebaseAuth: FirebaseAuth,
        firestore: FirebaseFirestore,
        storage: FirebaseStorage // Parâmetro storage adicionado
    ): AuthRepository {
        return FirebaseAuthRepositoryImpl(firebaseAuth, firestore, storage) // storage passado para o construtor
    }
}
