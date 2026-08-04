package com.vivicarmonadev.avatarapp.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    onIrAPerfil: () -> Unit,
    onIrAConfiguracion: () -> Unit,
    onIrAAvatares: () -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    // Se "suscribe" al StateFlow: cada vez que cambia, esto se redibuja solo
    val avatarFavorito by viewModel.avatarFavorito.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Hola 👋")

        Text(text = "Avatar favorito: ${avatarFavorito?.nombre ?: "Ninguno"}")

        Button(onClick = onIrAAvatares) {
            Text("Ver lista de avatares")
        }

        Button(onClick = onIrAPerfil) {
            Text("Ver mi perfil")
        }

        Button(onClick = onIrAConfiguracion) {
            Text("Configuración")
        }
    }
}
