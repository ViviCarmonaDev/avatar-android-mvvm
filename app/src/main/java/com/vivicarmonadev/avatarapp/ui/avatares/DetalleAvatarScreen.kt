package com.vivicarmonadev.avatarapp.ui.avatares

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import io.github.sceneview.node.ModelNode
import io.github.sceneview.rememberEngine
import io.github.sceneview.rememberModelLoader
import io.github.sceneview.rememberNode
import io.github.sceneview.Scene
import io.github.sceneview.animation.Transition.animateRotation

@Composable
fun DetalleAvatarScreen(
    viewModel: DetalleAvatarViewModel = viewModel()
) {
    val engine = rememberEngine()
    val modelLoader = rememberModelLoader(engine)

    val modelNode = rememberNode {
        ModelNode(
            modelInstance = modelLoader.createModelInstance(
                assetFileLocation = viewModel.archivoGlb
            ),
            scaleToUnits = 1.0f
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Scene(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            engine = engine,
            childNodes = listOf(modelNode)
        )

        Button(
            onClick = {
                modelNode.playAnimation(0) // reproduce la primera (y unica) animacion del glb
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text("Ver animación")
        }
    }
}