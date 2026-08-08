package com.vivicarmonadev.avatarapp.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UsuarioRepository(private val dao: UsuarioDao) {

    fun observarUsuario(): Flow<Usuario> {
        return dao.observarUsuario().map { entity ->
            entity?.let {
                Usuario(nombre = it.nombre, avatarFavoritoId = it.avatarFavoritoId)
            } ?: Usuario(nombre = "Usuario", avatarFavoritoId = "1") // valor por defecto si la tabla esta vacia
        }
    }

    fun observarTemaOscuro(): Flow<Boolean> {
        return dao.observarUsuario().map { it?.temaOscuro ?: false }
    }

    suspend fun guardarNombre(nombre: String, avatarFavoritoId: String, temaOscuro: Boolean) {
        dao.guardarUsuario(
            UsuarioEntity(
                id = 0,
                nombre = nombre,
                avatarFavoritoId = avatarFavoritoId,
                temaOscuro = temaOscuro
            )
        )
    }

    suspend fun guardarTema(temaOscuro: Boolean) {
        if (dao.existeUsuario() == 0) {
            // Si todavia no hay fila, creamos una con valores por defecto + el tema elegido
            dao.guardarUsuario(
                UsuarioEntity(id = 0, nombre = "Usuario", avatarFavoritoId = "1", temaOscuro = temaOscuro)
            )
        } else {
            dao.actualizarTema(temaOscuro)
        }
    }
}