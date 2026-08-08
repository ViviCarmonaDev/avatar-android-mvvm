package com.vivicarmonadev.avatarapp.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = viewModel()) {
    val avatarFavorito by viewModel.avatarFavorito.collectAsState()

    Column(modifier = Modifier.fillMaxSize().padding(24.dp)) {

        // --- Bloque saludo ---
        // Titulo grande con el nombre + subtitulo chico gris
        Text(text = "Hola 👋", style = MaterialTheme.typography.headlineMedium)
        Text(
            text = "Tu avatar favorito: ${avatarFavorito?.nombre ?: "Ninguno"}",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        Spacer(modifier = Modifier.height(20.dp))

        // --- Bloque buscador (visual)
        OutlinedTextField(
            value = "",
            onValueChange = { },
            placeholder = { Text("Buscar avatar...") },
            leadingIcon = { Icon(Icons.Filled.Search, contentDescription = null) },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        )
    }
}