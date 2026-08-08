package com.vivicarmonadev.avatarapp.ui.configuracion

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.vivicarmonadev.avatarapp.data.UsuarioRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ConfiguracionViewModel(
    private val repository: UsuarioRepository
) : ViewModel() {

    val temaOscuro: StateFlow<Boolean> = repository.observarTemaOscuro()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = false
        )

    fun cambiarTema(activado: Boolean) {
        viewModelScope.launch {
            repository.guardarTema(activado)
        }
    }
}