package com.marcos.quizapplication.ui.screens

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.marcos.quizapplication.R // Você precisará de um placeholder se R não estiver acessível aqui inicialmente
import com.marcos.quizapplication.ui.viewmodel.ProfileViewModel
import com.marcos.quizapplication.ui.viewmodel.ProfileUpdateState // Importar o ProfileUpdateState

@Composable
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    val user by viewModel.userState.collectAsState()
    val profileUpdateState by viewModel.profileUpdateState.collectAsState()
    val context = LocalContext.current

    // ActivityResultLauncher para selecionar imagem da galeria
    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            viewModel.updateProfilePicture(it)
        }
    }

    // Efeito para observar o estado da atualização do perfil e mostrar feedback
    LaunchedEffect(profileUpdateState) {
        when (val state = profileUpdateState) {
            is ProfileUpdateState.Success -> {
                Toast.makeText(context, "Profile picture updated successfully!", Toast.LENGTH_SHORT).show()
                viewModel.resetProfileUpdateState() // Resetar o estado após mostrar a mensagem
            }
            is ProfileUpdateState.Error -> {
                Toast.makeText(context, "Error: ${state.message}", Toast.LENGTH_LONG).show()
                viewModel.resetProfileUpdateState() // Resetar o estado
            }
            is ProfileUpdateState.Loading -> {
                // Poderia mostrar um diálogo de loading ou um indicador inline
                // O CircularProgressIndicator abaixo já cobre isso visualmente se não estiver em um diálogo
            }
            ProfileUpdateState.Idle -> {
                // Nada a fazer
            }
        }
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(32.dp))

            // Imagem de Perfil
            val imagePainter = rememberAsyncImagePainter(
                model = user?.photoUrl ?: R.drawable.ic_profile_placeholder, // Use seu placeholder
                 error = painterResource(id = R.drawable.ic_profile_placeholder),
                 placeholder = painterResource(id = R.drawable.ic_profile_placeholder)
            )

            Image(
                painter = imagePainter,
                contentDescription = "Profile Picture",
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .clickable {
                        imagePickerLauncher.launch("image/*")
                    },
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = user?.username ?: "Username not available",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = user?.email ?: "Email not available",
                style = MaterialTheme.typography.bodyMedium
            )

            Spacer(modifier = Modifier.weight(1f))

            if (profileUpdateState is ProfileUpdateState.Loading) {
                CircularProgressIndicator(modifier = Modifier.padding(16.dp))
            }
        }
    }
}
