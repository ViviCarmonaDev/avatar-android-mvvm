package com.vivicarmonadev.avatarapp.ui.perfil

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.MaterialTheme
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.Alignment
import androidx.compose.foundation.background
import androidx.compose.ui.graphics.Color
import com.vivicarmonadev.avatarapp.ui.theme.AzulPrincipal
import com.vivicarmonadev.avatarapp.AvatarApp
import com.vivicarmonadev.avatarapp.data.ViewModelFactory
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*

@Composable
fun PerfilScreen(
    onIrAConfiguracion: () -> Unit = {}
) {
    val context = LocalContext.current
    val app = context.applicationContext as AvatarApp
    val factory = ViewModelFactory(app.container.usuarioRepository)
    val viewModel: PerfilViewModel = viewModel(factory = factory)

    val usuario by viewModel.usuario.collectAsState()
    var textoNombre by remember(usuario.nombre) { mutableStateOf(usuario.nombre) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Fila superior: titulo + icono de configuracion a la derecha
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Mi Perfil", style = MaterialTheme.typography.headlineSmall)
            IconButton(onClick = onIrAConfiguracion) {
                Icon(Icons.Filled.Settings, contentDescription = "Configuración")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Circulo con la inicial del nombre, estilo avatar de perfil
        Box(
            modifier = Modifier
                .size(100.dp)
                .background(AzulPrincipal, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = usuario.nombre.firstOrNull()?.uppercase() ?: "?",
                color = Color.White,
                style = MaterialTheme.typography.headlineLarge
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = textoNombre,
            onValueChange = {
                textoNombre = it
                viewModel.cambiarNombre(it)
            },
            label = { Text("Nombre") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(text = "Avatar favorito: ${viewModel.avatarFavorito?.nombre ?: "Ninguno"}")
    }
}