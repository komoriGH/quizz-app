package com.marcos.quizapplication.domain.contracts

// Importar o User do pacote 'model'
import com.marcos.quizapplication.domain.model.User

// A data class User que estava aqui (contracts.User) foi removida.

data class AuthState(
    val user: User? = null, // Agora 'User' se refere a com.marcos.quizapplication.domain.model.User
    val isInitialLoading: Boolean = true
)
