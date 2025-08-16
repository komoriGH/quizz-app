package com.marcos.quizapplication.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.marcos.quizapplication.ui.screens.HomeScreen
import com.marcos.quizapplication.ui.screens.LoginScreen
import com.marcos.quizapplication.ui.screens.QuizRoute
import com.marcos.quizapplication.ui.viewmodel.HomeViewModel
import com.marcos.quizapplication.ui.viewmodel.LoginViewModel
import com.marcos.quizapplication.ui.viewmodel.QuizViewModel

sealed class Screen(val route: String) {
    object Login : Screen("login_screen")
    object Home : Screen("home_screen")
    object Quiz : Screen("quiz_screen/{quizId}") {
        fun createRoute(quizId: String) = "quiz_screen/$quizId"
    }
}

@Composable
fun NavGraph(navController: NavHostController, startDestination: String) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = Screen.Login.route) {
            val loginViewModel: LoginViewModel = hiltViewModel()
            // Usar collectAsStateWithLifecycle para coletar o estado de forma segura em relação ao ciclo de vida
            val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

            LoginScreen(
                uiState = uiState,
                onSignInClick = loginViewModel::signIn,
                // Adicionando o callback para o clique no botão de registro
                onSignUpClick = { email, password ->
                    loginViewModel.signUp(email, password)
                },
                onErrorMessageShown = loginViewModel::onErrorMessageShown,
                onLoginSuccess = {
                    navController.navigate(Screen.Home.route) {
                        // Limpa a pilha de volta até o destino inicial e o remove
                        popUpTo(navController.graph.startDestinationId) {
                            inclusive = true
                        }
                        // Garante que não haja múltiplas cópias da tela Home
                        launchSingleTop = true
                    }
                    // Você pode querer resetar o estado de loginSuccess no ViewModel aqui
                    // loginViewModel.onLoginSuccessShown() // Se você adicionar essa função ao ViewModel
                },
                // Adicionando o callback para quando o registro for bem-sucedido
                onRegistrationSuccess = {
                    // Após o registro, você pode querer que o usuário faça login.
                    // A LoginScreen já mostra um Toast.
                    // Apenas resetamos o estado no ViewModel.
                    loginViewModel.onRegistrationSuccessShown()
                }
            )
        }

        composable(route = Screen.Home.route) {
            val homeViewModel: HomeViewModel = hiltViewModel()
            val uiState by homeViewModel.uiState.collectAsStateWithLifecycle()

            HomeScreen(
                userName = uiState.userName, // Certifique-se de que HomeUiState tenha userName
                onLogout = {
                    homeViewModel.onLogout() // ViewModel deve lidar com a lógica de signOut do repositório
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Home.route) { // Pop até a Home para removê-la da pilha
                            inclusive = true
                        }
                        // Ou, para limpar toda a pilha e tornar Login o novo topo:
                        // popUpTo(navController.graph.id) { inclusive = true }
                        launchSingleTop = true
                    }
                },
                onStartQuizClick = { quizId ->
                    navController.navigate(Screen.Quiz.createRoute(quizId))
                }
            )
        }

        composable(route = Screen.Quiz.route) {
            val quizViewModel: QuizViewModel = hiltViewModel()
            // Se QuizRoute espera um QuizViewModel e não um uiState diretamente, isso está ok.
            // Se precisar de uiState, colete-o como nos outros composables.
            QuizRoute(
                viewModel = quizViewModel,
                onNavigateBack = { navController.popBackStack() },
                onNavigateHome = {
                    navController.navigate(Screen.Home.route) {
                        // Pop até a tela de Quiz para removê-la e Home se tornar o topo
                        popUpTo(Screen.Quiz.route) { // ou Screen.Quiz.createRoute(it.arguments?.getString("quizId") ?: "")
                            inclusive = true
                        }
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}
