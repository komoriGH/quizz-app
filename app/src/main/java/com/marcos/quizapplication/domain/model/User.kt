package com.marcos.quizapplication.domain.model

// Changed to data class and added uid and username
data class User(
    val uid: String,      // Added uid, should be non-null for an authenticated user
    val email: String?,
    val username: String?, // Added username
    val photoUrl: String? = null // Adicionado para a URL da foto de perfil, com valor padrão null
)
