package com.example.praksa

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class PraksaApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}