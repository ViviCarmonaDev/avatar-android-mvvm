package com.vivicarmonadev.avatarapp.ui.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.vivicarmonadev.avatarapp.ui.home.HomeScreen
import com.vivicarmonadev.avatarapp.ui.perfil.PerfilScreen
import com.vivicarmonadev.avatarapp.ui.configuracion.ConfiguracionScreen
import com.vivicarmonadev.avatarapp.ui.avatares.AvatarScreen

// Definimos las rutas como constantes, para no escribir strings sueltos por todos lados
object Rutas {
    const val HOME = "home"
    const val PERFIL = "perfil"
    const val CONFIGURACION = "configuracion"
    const val AVATARES = "avatares"
}

@Composable
fun AvatarAppNavGraph() {
    val navController: NavHostController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Rutas.HOME
    ) {
        composable(Rutas.HOME) {
            HomeScreen(
                onIrAPerfil = { navController.navigate(Rutas.PERFIL) },
                onIrAConfiguracion = { navController.navigate(Rutas.CONFIGURACION) },
                onIrAAvatares = { navController.navigate(Rutas.AVATARES) }
            )
        }
        composable(Rutas.PERFIL) {
            PerfilScreen()
        }
        composable(Rutas.CONFIGURACION) {
            ConfiguracionScreen()
        }
        composable(Rutas.AVATARES) {
            AvatarScreen()
        }
    }
}