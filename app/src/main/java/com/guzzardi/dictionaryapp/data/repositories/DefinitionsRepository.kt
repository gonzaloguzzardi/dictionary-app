package com.guzzardi.dictionaryapp.data.repositories

import com.guzzardi.dictionaryapp.data.datasources.DataSource
import com.guzzardi.dictionaryapp.data.model.DefinitionItemDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefinitionsRepository @Inject constructor(private val remoteDataSource: DataSource) {

    fun getDefinitionForWord(word: String): Flow<List<DefinitionItemDto>> {
        return remoteDataSource.fetchDefinitionsForWord(word)
    }
}