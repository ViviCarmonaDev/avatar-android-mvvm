package com.vivicarmonadev.avatarapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.vivicarmonadev.avatarapp.ui.theme.AzulPrincipal
import com.vivicarmonadev.avatarapp.ui.home.Rutas

// Barra inferior con 3 accesos: Home, Lista de avatares, Perfil.

@Composable
fun BottomNavBar(
    rutaActual: String,
    onIrAHome: () -> Unit,
    onIrAAvatares: () -> Unit,
    onIrAPerfil: () -> Unit
) {
    NavigationBar(
        containerColor = AzulPrincipal,
        modifier = Modifier.clip(RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp))
    ) {
        NavigationBarItem(
            selected = rutaActual == Rutas.HOME,
            onClick = onIrAHome,
            icon = { Icon(Icons.Filled.Home, contentDescription = "Home") },
            label = { Text("Home") },
            colors = navBarItemColors()
        )
        NavigationBarItem(
            selected = rutaActual == Rutas.AVATARES,
            onClick = onIrAAvatares,
            icon = { Icon(Icons.Filled.List, contentDescription = "Avatares") },
            label = { Text("Avatares") },
            colors = navBarItemColors()
        )
        NavigationBarItem(
            selected = rutaActual == Rutas.PERFIL,
            onClick = onIrAPerfil,
            icon = { Icon(Icons.Filled.Person, contentDescription = "Perfil") },
            label = { Text("Perfil") },
            colors = navBarItemColors()
        )
    }
}

// Colores de los items: blanco cuando esta seleccionado, gris clarito cuando no.
@Composable
private fun navBarItemColors() = NavigationBarItemDefaults.colors(
    selectedIconColor = Color.White,
    selectedTextColor = Color.White,
    unselectedIconColor = Color.White.copy(alpha = 0.5f),
    unselectedTextColor = Color.White.copy(alpha = 0.5f),
    indicatorColor = AzulPrincipal
)