package com.guzzardi.dictionaryapp.presentation.utils

import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.TextView

fun TextView.setTextOrGone(value: String?) {
    if (value.isNullOrBlank()) {
        visibility = GONE
    } else {
        visibility = VISIBLE
        text = value
    }
}