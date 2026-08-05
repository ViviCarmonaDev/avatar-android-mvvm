package com.vivicarmonadev.avatarapp.ui.avatares

import androidx.lifecycle.ViewModel
import com.vivicarmonadev.avatarapp.data.Avatar
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AvataresViewModel: ViewModel() {
    private val _avatares = MutableStateFlow<List<Avatar>>(emptyList())
    val avatares: StateFlow<List<Avatar>> = _avatares

    init {
        // Datos de prueba, mas adelante vendran de un Repository/Blender export real
        _avatares.value = listOf(
            Avatar(id = "1", nombre = "Robotito", archivoGlb = "robotito.glb"),
            Avatar(id = "2", nombre = "Zorrito", archivoGlb = "zorrito.glb"),
            Avatar(id = "3", nombre = "Astronauta", archivoGlb = "astronauta.glb")
        )
    }
}