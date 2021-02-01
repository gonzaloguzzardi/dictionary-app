package com.guzzardi.dictionaryapp.presentation.views.definitions

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.guzzardi.dictionaryapp.data.model.DefinitionItemDto

class DefinitionsRecyclerView(context: Context, attrs: AttributeSet? = null) :
    RecyclerView(context, attrs) {

    init {
        setHasFixedSize(true)
        overScrollMode = OVER_SCROLL_NEVER
        layoutManager = LinearLayoutManager(context)
    }

    fun setData(definitions: List<DefinitionItemDto>) {
        adapter = DefinitionsAdapter(definitions)
    }
}