package com.guzzardi.dictionaryapp.presentation.application

import android.app.Application
import com.facebook.stetho.Stetho
import com.guzzardi.dictionaryapp.BuildConfig
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class UrbanDictionaryApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}