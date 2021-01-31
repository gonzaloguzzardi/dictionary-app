package com.guzzardi.dictionaryapp.presentation

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(application = TestApplication::class)
abstract class RobolectricTest {
    protected val context: Context = ApplicationProvider.getApplicationContext()
}