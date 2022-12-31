package com.artsmeet.app.android

import android.app.Application
import com.artsmeet.app.core.ArtsMeet
import com.google.firebase.FirebaseApp
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class ArtsMeetApp: Application() {

    override fun onCreate() {
        super.onCreate()
        ArtsMeet.applicationContext = applicationContext
        FirebaseApp.initializeApp(applicationContext)
    }
}