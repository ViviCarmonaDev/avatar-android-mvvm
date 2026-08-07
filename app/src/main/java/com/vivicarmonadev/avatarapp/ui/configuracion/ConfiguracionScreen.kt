package com.vivicarmonadev.avatarapp.ui.configuracion

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun ConfiguracionScreen(
    viewModel: ConfiguracionViewModel = viewModel()
) {
    val temaOscuro by viewModel.temaOscuro.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Configuración")

        Row(
            verticalAlignment = androidx.compose.ui.Alignment.CenterVertically,
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