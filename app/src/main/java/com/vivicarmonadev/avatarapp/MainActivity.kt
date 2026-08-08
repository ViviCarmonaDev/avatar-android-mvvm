package com.vivicarmonadev.avatarapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.vivicarmonadev.avatarapp.ui.home.AvatarAppNavGraph
import com.vivicarmonadev.avatarapp.ui.theme.AvatarAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val app = application as AvatarApp
            val temaOscuro by app.container.usuarioRepository
                .observarTemaOscuro()
                .collectAsStateWithLifecycle(initialValue = false)

            AvatarAppTheme(darkTheme = temaOscuro) {
                AvatarAppNavGraph()
            }
        }
    }
}
