package com.vivicarmonadev.avatarapp.ui.avatares

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.vivicarmonadev.avatarapp.data.Avatar

class DetalleAvatarViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    // Recibimos el nombre del archivo .glb como argumento de navegacion
    val archivoGlb: String = savedStateHandle.get<String>("archivoGlb") ?: ""
}