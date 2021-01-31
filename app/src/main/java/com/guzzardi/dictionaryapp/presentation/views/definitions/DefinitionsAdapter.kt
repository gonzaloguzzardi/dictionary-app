package com.guzzardi.dictionaryapp.presentation.views.definitions

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guzzardi.dictionaryapp.data.DefinitionItemDto

class DefinitionsAdapter(private val definitions: MutableList<DefinitionItemDto>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DefinitionViewHolder.create(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val postItem = definitions[position]
        (holder as DefinitionViewHolder).bind(postItem)
    }

    override fun getItemCount() = 0
}