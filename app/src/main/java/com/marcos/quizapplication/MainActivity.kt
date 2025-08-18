package com.marcos.quizapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.compose.rememberNavController
import com.marcos.quizapplication.navigation.NavGraph
import com.marcos.quizapplication.navigation.Screen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.marcos.quizapplication.domain.contracts.AuthState // Importar AuthState
import com.marcos.quizapplication.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().apply {
            setKeepOnScreenCondition {
                // MODIFICADO AQUI: Verificar se o estado é InitialLoading
                viewModel.authState.value is AuthState.InitialLoading
            }
        }

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                val navController = rememberNavController()
                // Coletar o AuthState completo
                val currentAuthState by viewModel.authState.collectAsStateWithLifecycle()

                // MODIFICADO AQUI: Determinar o destino inicial baseado no tipo de AuthState
                val startDestination = when (currentAuthState) {
                    is AuthState.Authenticated -> Screen.Home.route
                    is AuthState.InitialLoading -> Screen.Login.route // Ou uma tela de loading se você tiver uma
                    is AuthState.Unauthenticated -> Screen.Login.route
                    is AuthState.Error -> Screen.Login.route // Ou uma tela de erro/login
                                                            // Para InitialLoading e Error, Login é um fallback seguro
                                                            // se você não tiver telas específicas para esses estados.
                }

                // Só renderiza o NavGraph se não estiver no estado de carregamento inicial
                // para evitar piscar a tela de login brevemente se o usuário já estiver logado.
                // A splash screen já está tratando o keepOnScreenCondition para InitialLoading.
                // Esta verificação aqui é para o startDestination do NavGraph.
                if (currentAuthState !is AuthState.InitialLoading) {
                    NavGraph(
                        navController = navController,
                        startDestination = startDestination
                    )
                }
                // Se currentAuthState for InitialLoading, a splash screen ainda estará visível,
                // e o Surface ficará aqui (pode ser vazio ou com um placeholder se desejar),
                // até que o estado mude e o NavGraph seja composto.
            }
        }
    }
}
