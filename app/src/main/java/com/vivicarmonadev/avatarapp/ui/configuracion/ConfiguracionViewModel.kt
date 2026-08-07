package com.vivicarmonadev.avatarapp.ui.configuracion

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class ConfiguracionViewModel : ViewModel() {
    private val _temaOscuro = MutableStateFlow(false)
    val temaOscuro: StateFlow<Boolean> = _temaOscuro

    fun cambiarTema(activado: Boolean) {
        _temaOscuro.value = activado
    }
}