package com.vivicarmonadev.avatarapp.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface UsuarioDao {

    @Query("SELECT * FROM usuario WHERE id = 0 LIMIT 1")
    fun observarUsuario(): Flow<UsuarioEntity?>

    @Upsert
    suspend fun guardarUsuario(usuario: UsuarioEntity)
}