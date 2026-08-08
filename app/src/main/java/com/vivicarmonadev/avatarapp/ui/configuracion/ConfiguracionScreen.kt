package com.vivicarmonadev.avatarapp.ui.configuracion

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vivicarmonadev.avatarapp.AvatarApp
import com.vivicarmonadev.avatarapp.data.ViewModelFactory


@Composable
fun ConfiguracionScreen() {
    val context = LocalContext.current
    val app = context.applicationContext as AvatarApp
    val factory = ViewModelFactory(app.container.usuarioRepository)
    val viewModel: ConfiguracionViewModel = viewModel(factory = factory)
    val temaOscuro by viewModel.temaOscuro.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Configuración", style = MaterialTheme.typography.headlineSmall)

        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Tema oscuro")
            Switch(
                checked = temaOscuro,
                onCheckedChange = { viewModel.cambiarTema(it) }
            )
        }
    }
}