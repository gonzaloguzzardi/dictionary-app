package com.guzzardi.dictionaryapp.presentation.views.definitions

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.guzzardi.dictionaryapp.R
import com.guzzardi.dictionaryapp.data.model.DefinitionItemDto
import com.guzzardi.dictionaryapp.databinding.ViewHolderDefinitionBinding
import com.guzzardi.dictionaryapp.presentation.utils.setTextOrGone

class DefinitionViewHolder(binding: ViewHolderDefinitionBinding) :
    RecyclerView.ViewHolder(binding.root) {

    companion object {
        private const val DEFAULT_VOTES_VALUE = "0"

        fun create(parent: ViewGroup): RecyclerView.ViewHolder {
            val binding = ViewHolderDefinitionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
            return DefinitionViewHolder(binding)
        }
    }

    val definitionText = binding.definitionValueText
    val authorText = binding.definitionAuthorText
    val upVotes = binding.upVotesText
    val downVotes = binding.downVotesText

    fun bind(data: DefinitionItemDto) {
        definitionText.setTextOrGone(data.definition)
        authorText.setTextOrGone(createAuthorText(data.author))
        upVotes.setTextOrGone(data.thumbsUp?.toString() ?: DEFAULT_VOTES_VALUE)
        downVotes.setTextOrGone(data.thumbsDown?.toString() ?: DEFAULT_VOTES_VALUE)
    }

    private fun createAuthorText(author: String?): String? {
        if (author.isNullOrBlank()) return null

        val prefix = itemView.resources.getString(R.string.text_view_definition_author_prefix)
        return "$prefix $author"
    }
}