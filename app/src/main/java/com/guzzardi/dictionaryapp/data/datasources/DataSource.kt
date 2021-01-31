package com.guzzardi.dictionaryapp.data.datasources

import com.guzzardi.dictionaryapp.data.model.DefinitionItemDto
import kotlinx.coroutines.flow.Flow

interface DataSource {
    fun fetchDefinitionsForWord(word: String): Flow<List<DefinitionItemDto>>
}