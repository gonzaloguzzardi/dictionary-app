package com.guzzardi.dictionaryapp.data.repositories

import com.guzzardi.dictionaryapp.data.datasources.DataSource
import com.guzzardi.dictionaryapp.data.model.DefinitionsApiResponse
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DefinitionsRepository @Inject constructor(private val remoteDataSource: DataSource) {

    fun getDefinitionsForWord(word: String): Flow<DefinitionsApiResponse> {
        return remoteDataSource.fetchDefinitionsForWord(word)
    }
}