package com.vivicarmonadev.avatarapp.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import com.vivicarmonadev.avatarapp.ui.perfil.PerfilViewModel
import com.vivicarmonadev.avatarapp.ui.configuracion.ConfiguracionViewModel

class ViewModelFactory(
    private val repository: UsuarioRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ): T {
        return when {
            modelClass.isAssignableFrom(PerfilViewModel::class.java) ->
                PerfilViewModel(repository) as T

            modelClass.isAssignableFrom(ConfiguracionViewModel::class.java) ->
                ConfiguracionViewModel(repository) as T

            else -> throw IllegalArgumentException("ViewModel desconocido: ${modelClass.name}")
        }
    }
}