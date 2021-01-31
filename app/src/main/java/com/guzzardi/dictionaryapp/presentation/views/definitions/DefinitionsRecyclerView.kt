package com.guzzardi.dictionaryapp.presentation.views.definitions

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DefinitionsRecyclerView(context: Context, attrs: AttributeSet? = null) :
    RecyclerView(context, attrs) {

    init {
        setHasFixedSize(true)
        overScrollMode = OVER_SCROLL_NEVER
        layoutManager = LinearLayoutManager(context)
        val itemDecorator = DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL)
        addItemDecoration(itemDecorator)
    }

    fun setData() {
        adapter = DefinitionsAdapter()
    }
}