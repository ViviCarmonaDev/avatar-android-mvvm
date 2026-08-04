package com.vivicarmonadev.avatarapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.vivicarmonadev.avatarapp.ui.home.AvatarAppNavGraph
import com.vivicarmonadev.avatarapp.ui.theme.AvatarAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AvatarAppTheme {
                AvatarAppNavGraph()
                }
            }
        }
    }
