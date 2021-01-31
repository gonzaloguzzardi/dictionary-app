package com.guzzardi.dictionaryapp.data.datasources.network

import com.guzzardi.dictionaryapp.data.DefinitionItemDto
import com.guzzardi.dictionaryapp.data.datasources.DataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val urbanDictionaryService: UrbanDictionaryService): DataSource {

    override fun fetchDefinitionsForWord(word: String): Flow<List<DefinitionItemDto>> = flow {
        val fetchedDefinitions = urbanDictionaryService.getDefinitionForWord(word)
        emit(fetchedDefinitions)
    }.flowOn(Dispatchers.IO)
}