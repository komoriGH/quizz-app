package com.marcos.quizapplication.domain.contracts

import kotlinx.coroutines.flow.StateFlow

interface AuthRepository {
    val authState: StateFlow<AuthState> // Modificado aqui
    suspend fun signUp(username: String, email: String, password: String): Result<Unit>
    suspend fun signIn(email: String, password: String): Result<Unit>
    fun signOut()
    suspend fun updateProfilePicture(imageUriString: String): Result<Unit>
}

