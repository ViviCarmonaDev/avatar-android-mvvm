package com.vivicarmonadev.avatarapp.ui.perfil

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.platform.LocalContext
import com.vivicarmonadev.avatarapp.AvatarApp
import com.vivicarmonadev.avatarapp.data.ViewModelFactory

@Composable
fun PerfilScreen() {
    val context = LocalContext.current
    val app = context.applicationContext as AvatarApp
    val factory = ViewModelFactory(app.container.usuarioRepository)

    val viewModel: PerfilViewModel = viewModel(factory = factory)

    val usuario by viewModel.usuario.collectAsState()
    var textoNombre by remember(usuario.nombre) { mutableStateOf(usuario.nombre) }

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Mi Perfil")

        OutlinedTextField(
            value = textoNombre,
            onValueChange = {
                textoNombre = it
                viewModel.cambiarNombre(it)
            },
            label = { Text("Nombre") }
        )

        Text(text = "Avatar favorito: ${viewModel.avatarFavorito?.nombre ?: "Ninguno"}")
    }
}