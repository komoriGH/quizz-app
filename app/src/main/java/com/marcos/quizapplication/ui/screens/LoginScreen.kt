package com.marcos.quizapplication.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
// import androidx.compose.foundation.layout.Row // Not strictly needed for the current layout
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
// import androidx.compose.foundation.text.ClickableText // Mantenha se for usar
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
// import androidx.compose.material3.Checkbox // Não usado
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
// import androidx.compose.material3.MaterialTheme // Not strictly needed for this file's direct composables
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
// import androidx.compose.ui.text.AnnotatedString // Mantenha se for usar
// import androidx.compose.ui.text.TextStyle // Mantenha se for usar
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.marcos.quizapplication.ui.viewmodel.LoginUiState


@Composable
fun LoginScreen(
    uiState: LoginUiState,
    onSignInClick: (String, String) -> Unit,
    onSignUpClick: () -> Unit,
    onErrorMessageShown: () -> Unit,
    onLoginSuccess: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) } // Estado para visibilidade da senha

    val context = LocalContext.current

    LaunchedEffect(uiState.errorMessage) {
        uiState.errorMessage?.let { message ->
            Toast.makeText(context, message, Toast.LENGTH_LONG).show()
            onErrorMessageShown()
        }
    }

    LaunchedEffect(uiState.loginSuccess) {
        if (uiState.loginSuccess) {
            onLoginSuccess()
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to\nQuizMaster",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "Sign in or create an account",
                fontSize = 16.sp,
                color = Color.Gray,
                textAlign = TextAlign.Start,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(32.dp))

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Email address") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                enabled = !uiState.isLoading
            )
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Password") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                enabled = !uiState.isLoading,
                trailingIcon = {
                    val image = if (passwordVisible)
                        Icons.Filled.Visibility
                    else
                        Icons.Filled.VisibilityOff

                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(imageVector = image, description)
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp)) // Este Spacer controla o espaço APÓS o campo de senha

            // Se você quiser um espaço antes do botão "Sign in", ele estaria aqui.
            // O Spacer(modifier = Modifier.height(24.dp)) foi removido na última atualização, 
            // se precisar de mais espaço antes dos botões, adicione um novo aqui.
            // Exemplo: Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { onSignInClick(email, password) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                enabled = !uiState.isLoading && email.isNotBlank() && password.isNotBlank()
            ) {
                Text("Sign in", fontSize = 16.sp)
            }
            Spacer(modifier = Modifier.height(16.dp))

            OutlinedButton(
                onClick = onSignUpClick,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                enabled = !uiState.isLoading,
                colors = ButtonDefaults.outlinedButtonColors()
            ) {
                Text("Sign up", fontSize = 16.sp)
            }
            // Spacer(modifier = Modifier.height(16.dp)) // Removido na última atualização; adicione se desejar mais espaço na parte inferior
        }

        if (uiState.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        uiState = LoginUiState(isLoading = false),
        onSignInClick = { _, _ -> },
        onSignUpClick = {},
        onErrorMessageShown = {},
        onLoginSuccess = {}
    )
}
