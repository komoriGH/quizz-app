package com.marcos.quizapplication.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.marcos.quizapplication.domain.contracts.AuthRepository
import com.marcos.quizapplication.domain.contracts.AuthState
import com.marcos.quizapplication.domain.model.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest // ou apenas collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _user = MutableStateFlow<User?>(null)
    val user: StateFlow<User?> = _user.asStateFlow()

    private val _isLoading = MutableStateFlow(true) // Para o estado de carregamento inicial do usuário
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    init {
        observeUserAuthState()
    }

    private fun observeUserAuthState() {
        viewModelScope.launch {
            // MODIFICADO AQUI: authRepository.getAuthState() para authRepository.authState
            authRepository.authState.map { authState ->
                when (authState) {
                    is AuthState.Authenticated -> {
                        _isLoading.value = false
                        authState.user
                    }
                    is AuthState.Unauthenticated -> {
                        _isLoading.value = false
                        null
                    }
                    is AuthState.InitialLoading -> {
                        _isLoading.value = true // Continua carregando
                        null
                    }
                    is AuthState.Error -> {
                        _isLoading.value = false
                        // Tratar erro, talvez logar ou expor para a UI
                        null
                    }
                }
            }.collectLatest { userValue -> // ou .collect se collectLatest não for estritamente necessário
                _user.value = userValue
            }
        }
    }

    fun logout() {
        authRepository.signOut()
        // Após o signOut, o _user será atualizado para null pelo observador acima
        // e isLoading também será ajustado.
    }
}
