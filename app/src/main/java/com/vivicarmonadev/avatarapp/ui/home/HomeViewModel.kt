package com.vivicarmonadev.avatarapp.ui.home

import androidx.lifecycle.ViewModel
import com.vivicarmonadev.avatarapp.data.Avatar
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow


class HomeViewModel: ViewModel() {

    // Estado privado y mutable: solo el ViewModel puede cambiarlo
    private val _avatarFavorito = MutableStateFlow<Avatar?>(null)

    // Estado público e inmutable: la View solo puede leerlo
    val avatarFavorito: StateFlow<Avatar?> = _avatarFavorito

    init {
        // Por ahora, datos de prueba (mock). Más adelante vendrá de un Repository.
        _avatarFavorito.value = Avatar(
            id = "1",
            nombre = "Robotito",
            archivoGlb = "robotito.glb"
        )
    }
}