package com.vivicarmonadev.avatarapp.ui.perfil

import androidx.lifecycle.ViewModel
import com.vivicarmonadev.avatarapp.data.Avatar
import com.vivicarmonadev.avatarapp.data.Usuario
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class PerfilViewModel : ViewModel(){
    private val _usuario = MutableStateFlow(
        Usuario(nombre = "Tony", avatarFavoritoId = "1")
    )
    val usuario: StateFlow<Usuario> = _usuario

    // Mock de avatares disponibles, en el futuro esto vendra de un Repository compartido
    private val avataresDisponibles = listOf(
        Avatar(id = "1", nombre = "Robotito", archivoGlb = "robotito.glb"),
        Avatar(id = "2", nombre = "Zorrito", archivoGlb = "zorrito.glb"),
        Avatar(id = "3", nombre = "Astronauta", archivoGlb = "astronauta.glb")
    )

    val avatarFavorito: Avatar?
        get() = avataresDisponibles.find { it.id == _usuario.value.avatarFavoritoId }

    fun cambiarNombre(nuevoNombre: String) {
        _usuario.value = _usuario.value.copy(nombre = nuevoNombre)
    }
}