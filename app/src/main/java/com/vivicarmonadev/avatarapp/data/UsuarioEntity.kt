package com.vivicarmonadev.avatarapp.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "usuario")
data class UsuarioEntity(
    @PrimaryKey
    val id: Int = 0, // Solo va a existir 1 fila, siempre con id=0
    val nombre: String,
    val avatarFavoritoId: String,
    val temaOscuro: Boolean
)