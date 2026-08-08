package com.vivicarmonadev.avatarapp.ui.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavType
import androidx.navigation.navArgument
import androidx.compose.ui.Modifier
import androidx.compose.runtime.getValue
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import com.vivicarmonadev.avatarapp.ui.BottomNavBar
import com.vivicarmonadev.avatarapp.ui.perfil.PerfilScreen
import com.vivicarmonadev.avatarapp.ui.configuracion.ConfiguracionScreen
import com.vivicarmonadev.avatarapp.ui.avatares.AvataresScreen
import com.vivicarmonadev.avatarapp.ui.avatares.DetalleAvatarScreen

// Definimos las rutas como constantes, para no escribir strings sueltos por todos lados
object Rutas {
    const val HOME = "home"
    const val PERFIL = "perfil"
    const val CONFIGURACION = "configuracion"
    const val AVATARES = "avatares"
    const val DETALLE_AVATAR = "detalle_avatar/{archivoGlb}"
}

@Composable
fun AvatarAppNavGraph() {
    val navController: NavHostController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()
    val rutaActual = backStackEntry?.destination?.route ?: Rutas.HOME

    // Mostramos el BottomNavBar solo en las 3 pantallas principales
    val mostrarBottomBar = rutaActual in listOf(Rutas.HOME, Rutas.AVATARES, Rutas.PERFIL)

    Scaffold(
        bottomBar = {
            if (mostrarBottomBar) {
                BottomNavBar(
                    rutaActual = rutaActual,
                    onIrAHome = { navController.navigate(Rutas.HOME) },
                    onIrAAvatares = { navController.navigate(Rutas.AVATARES) },
                    onIrAPerfil = { navController.navigate(Rutas.PERFIL) }
                )
            }
        }
    ) { paddingInterno ->
        NavHost(
            navController = navController,
            startDestination = Rutas.HOME,
            modifier = Modifier.padding(paddingInterno)
        ) {
            composable(Rutas.HOME) {
                HomeScreen()
            }
            composable(Rutas.PERFIL) {
                PerfilScreen(
                    onIrAConfiguracion = { navController.navigate(Rutas.CONFIGURACION)}
                )
            }
            composable(Rutas.CONFIGURACION) {
                ConfiguracionScreen()
            }
            composable(Rutas.AVATARES) {
                AvataresScreen(
                    onAvatarSeleccionado = { avatar ->
                        navController.navigate("detalle_avatar/${avatar.archivoGlb}")
                    }
                )
            }
            composable(
                route = Rutas.DETALLE_AVATAR,
                arguments = listOf(navArgument("archivoGlb") { type = NavType.StringType })
            ) {
                DetalleAvatarScreen()
            }
        }
    }
}