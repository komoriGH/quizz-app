package com.marcos.quizapplication.ui.viewmodel

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcos.quizapplication.domain.contracts.AuthRepository
import com.marcos.quizapplication.domain.contracts.AuthState // Certifique-se que esta importação está correta
import com.marcos.quizapplication.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map // collect é pego de kotlinx.coroutines.flow.FlowKt
import kotlinx.coroutines.launch
import javax.inject.Inject

// ProfileUpdateState (sealed class) permanece o mesmo
sealed class ProfileUpdateState {
    object Idle : ProfileUpdateState()
    object Loading : ProfileUpdateState()
    object Success : ProfileUpdateState()
    data class Error(val message: String) : ProfileUpdateState()
}

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _userState = MutableStateFlow<User?>(null)
    val userState: StateFlow<User?> = _userState.asStateFlow()

    private val _profileUpdateState = MutableStateFlow<ProfileUpdateState>(ProfileUpdateState.Idle)
    val profileUpdateState: StateFlow<ProfileUpdateState> = _profileUpdateState.asStateFlow()

    // Pode haver um StateFlow para erros gerais de autenticação se necessário
    // private val _authErrorState = MutableStateFlow<String?>(null)
    // val authErrorState: StateFlow<String?> = _authErrorState.asStateFlow()

    init {
        observeAuthState()
    }

    private fun observeAuthState() {
        viewModelScope.launch {
            authRepository.authState.map { authState -> // MODIFICADO AQUI: getAuthState() para authState
                when (authState) {
                    is AuthState.Authenticated -> {
                        // _authErrorState.value = null // Limpar erro anterior se houver
                        authState.user
                    }
                    is AuthState.Unauthenticated -> {
                        // _authErrorState.value = null
                        null
                    }
                    is AuthState.InitialLoading -> {
                        // _authErrorState.value = null
                        // Pode-se querer um User placeholder para indicar loading
                        null 
                    }
                    is AuthState.Error -> {
                        // _authErrorState.value = authState.message // Expor mensagem de erro se necessário
                        // Manter o usuário anterior ou limpar? Depende da UX desejada.
                        // Se o erro for sobre o carregamento do usuário, então null é apropriado.
                        null 
                    }
                }
            }.collect { user ->
                _userState.value = user
            }
        }
    }

    fun updateProfilePicture(imageUri: Uri?) {
        if (imageUri == null) {
            _profileUpdateState.value = ProfileUpdateState.Error("Image URI cannot be null.")
            return
        }

        viewModelScope.launch {
            _profileUpdateState.value = ProfileUpdateState.Loading
            val result = authRepository.updateProfilePicture(imageUri.toString())
            result.fold(
                onSuccess = {
                    _profileUpdateState.value = ProfileUpdateState.Success
                },
                onFailure = { exception ->
                    _profileUpdateState.value = ProfileUpdateState.Error(exception.message ?: "Failed to update profile picture.")
                }
            )
        }
    }

    fun resetProfileUpdateState() {
        _profileUpdateState.value = ProfileUpdateState.Idle
    }
}

