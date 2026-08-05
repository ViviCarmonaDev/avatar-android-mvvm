package com.vivicarmonadev.avatarapp.ui.avatares

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vivicarmonadev.avatarapp.data.Avatar

@Composable
fun AvataresScreen(
    onAvatarSeleccionado: (Avatar) -> Unit,
    viewModel: AvataresViewModel = viewModel()
) {
    val avatares by viewModel.avatares.collectAsState()

    LazyColumn(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(avatares) { avatar ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { onAvatarSeleccionado(avatar) }
            ) {
                Text(
                    text = avatar.nombre,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
    }

}