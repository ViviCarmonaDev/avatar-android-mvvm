package com.vivicarmonadev.avatarapp.data

import android.content.Context

class AppContainer(context: Context) {
    private val database = AppDatabase.getInstance(context)
    val usuarioRepository = UsuarioRepository(database.usuarioDao())
}