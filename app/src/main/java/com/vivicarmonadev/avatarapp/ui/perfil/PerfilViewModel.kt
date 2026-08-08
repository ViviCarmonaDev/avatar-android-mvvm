package com.vivicarmonadev.avatarapp.ui.perfil

import androidx.lifecycle.ViewModel
import com.vivicarmonadev.avatarapp.data.Avatar
import com.vivicarmonadev.avatarapp.data.Usuario
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope
import com.vivicarmonadev.avatarapp.data.UsuarioRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class PerfilViewModel(
    private val repository: UsuarioRepository
) : ViewModel() {

    val usuario: StateFlow<Usuario> = repository.observarUsuario()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = Usuario(nombre = "Usuario", avatarFavoritoId = "1")
        )

    private val avataresDisponibles = listOf(
        Avatar(id = "1", nombre = "Robotito", archivoGlb = "robotito.glb"),
        Avatar(id = "2", nombre = "Zorrito", archivoGlb = "zorrito.glb"),
        Avatar(id = "3", nombre = "Astronauta", archivoGlb = "astronauta.glb")
    )

    val avatarFavorito: Avatar?
        get() = avataresDisponibles.find { it.id == usuario.value.avatarFavoritoId }

    fun cambiarNombre(nuevoNombre: String) {
        viewModelScope.launch {
            repository.guardarNombre(
                nombre = nuevoNombre,
                avatarFavoritoId = usuario.value.avatarFavoritoId,
                temaOscuro = false
            )
        }
    }
}