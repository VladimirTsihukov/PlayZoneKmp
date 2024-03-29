package com.tishukoff.playzonekmp.android

import PlatformConfiguration
import PlatformSDK
import android.app.Application

class PlayzoneApp: Application() {

    override fun onCreate() {
        super.onCreate()

        initPlatformSDK()
    }
}

fun PlayzoneApp.initPlatformSDK() = PlatformSDK.init(configuration = PlatformConfiguration(applicationContext))