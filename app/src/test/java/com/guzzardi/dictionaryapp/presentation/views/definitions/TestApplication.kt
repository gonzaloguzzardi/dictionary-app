package com.guzzardi.dictionaryapp.presentation.views.definitions

import android.app.Application
import com.guzzardi.dictionaryapp.R

class TestApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        setTheme(R.style.Theme_Dictionaryapp)
    }
}