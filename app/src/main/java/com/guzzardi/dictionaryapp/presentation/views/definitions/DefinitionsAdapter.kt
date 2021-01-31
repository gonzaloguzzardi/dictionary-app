package com.guzzardi.dictionaryapp.presentation.views.definitions

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class DefinitionsAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DefinitionViewHolder.create(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemCount() = 0
}