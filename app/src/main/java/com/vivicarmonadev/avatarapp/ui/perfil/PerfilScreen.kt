package com.vivicarmonadev.avatarapp.ui.perfil

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun PerfilScreen(
    viewModel: PerfilViewModel = viewModel()
) {
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