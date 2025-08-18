package com.marcos.quizapplication.domain.contracts

import com.marcos.quizapplication.domain.model.User

sealed interface AuthState {
    object InitialLoading : AuthState // Para substituir o isInitialLoading
    data class Authenticated(val user: User) : AuthState
    object Unauthenticated : AuthState
    data class Error(val message: String) : AuthState
    // Você pode adicionar outros estados se necessário, como 'Loading' para operações.
}