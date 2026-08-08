package com.vivicarmonadev.avatarapp.ui.avatares

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vivicarmonadev.avatarapp.data.Avatar
import com.vivicarmonadev.avatarapp.ui.theme.AzulPrincipal


/**
 * Pantalla que muestra la lista completa de avatares del usuario en formato grid (2 columnas).
 * Cada avatar se ve como una tarjeta (AvatarCard) y al tocarla navega al detalle/animacion 3D.
 */
@Composable
fun AvataresScreen(
    onAvatarSeleccionado: (Avatar) -> Unit,
    viewModel: AvataresViewModel = viewModel()
) {
    val avatares by viewModel.avatares.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        // --- Titulo de la pantalla ---
        Text(
            text = "Mi lista de Avatares",
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 16.dp)
        )

        // Grid de 2 columnas
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            items(avatares) { avatar ->
                AvatarCard(avatar = avatar, onClick = { onAvatarSeleccionado(avatar) })
            }
        }
    }
}

/**
 * Tarjeta individual de un avatar dentro del grid.
 * Muestra un placeholder visual, el nombre del avatar, y un boton circular
 * que dispara la navegacion hacia la pantalla de detalle/animacion 3D.
 */
@Composable
private fun AvatarCard(avatar: Avatar, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .background(AzulPrincipal, RoundedCornerShape(20.dp))
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        // Placeholder visual del avatar
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(androidx.compose.ui.graphics.Color.White.copy(alpha = 0.15f), RoundedCornerShape(12.dp))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(text = avatar.nombre, color = androidx.compose.ui.graphics.Color.White)

        Spacer(modifier = Modifier.height(8.dp))

        // Boton circular blanco, dispara "ver animacion"
        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
            IconButton(
                onClick = onClick,
                modifier = Modifier
                    .size(36.dp)
                    .background(androidx.compose.ui.graphics.Color.White, CircleShape)
            ) {
                Icon(Icons.Filled.PlayArrow, contentDescription = "Ver animación", tint = AzulPrincipal)
            }
        }
    }
}