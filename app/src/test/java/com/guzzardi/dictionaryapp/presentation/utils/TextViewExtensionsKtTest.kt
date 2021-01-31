package com.guzzardi.dictionaryapp.presentation.utils

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView
import com.guzzardi.dictionaryapp.presentation.RobolectricTest
import org.junit.Assert
import org.junit.Test

class TextViewExtensionsKtTest: RobolectricTest() {

    @Test
    fun `SetTextOrGone with non null value sets value in textView text field`() {
        val textView = TextView(context)
        val expectedValue = "test value"

        textView.setTextOrGone(expectedValue)

        Assert.assertEquals(expectedValue, textView.text)
    }

    @Test
    fun `SetTextOrGone with non null value sets visibility to VISIBLE`() {
        val textView = TextView(context)

        textView.setTextOrGone("value")

        Assert.assertEquals(VISIBLE, textView.visibility)
    }

    @Test
    fun `SetTextOrGone with null value sets visibility to GONE`() {
        val textView = TextView(context)

        textView.setTextOrGone(null)

        Assert.assertEquals(GONE, textView.visibility)
    }

    @Test
    fun `SetTextOrGone with blank value sets visibility to GONE`() {
        val textView = TextView(context)

        textView.setTextOrGone(" ")

        Assert.assertEquals(GONE, textView.visibility)
    }
}