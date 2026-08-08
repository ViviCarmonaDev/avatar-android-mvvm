package com.vivicarmonadev.avatarapp

import android.app.Application
import com.vivicarmonadev.avatarapp.data.AppContainer

class AvatarApp : Application() {
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppContainer(this)
    }
}