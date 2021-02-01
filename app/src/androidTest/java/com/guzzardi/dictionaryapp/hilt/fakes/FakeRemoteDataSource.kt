package com.guzzardi.dictionaryapp.hilt.fakes

import com.guzzardi.dictionaryapp.data.datasources.DataSource
import com.guzzardi.dictionaryapp.data.model.DefinitionItemDto
import com.guzzardi.dictionaryapp.data.model.DefinitionsApiResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeRemoteDataSource : DataSource {
    override fun fetchDefinitionsForWord(word: String): Flow<DefinitionsApiResponse> = flow {
        val data = DefinitionItemDto("definition", "author", 5, 2)
        emit(DefinitionsApiResponse(listOf(data)))
    }
}