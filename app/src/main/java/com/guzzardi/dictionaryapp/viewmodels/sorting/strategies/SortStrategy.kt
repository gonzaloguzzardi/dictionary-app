package com.guzzardi.dictionaryapp.viewmodels.sorting.strategies

import com.guzzardi.dictionaryapp.data.model.DefinitionsApiResponse

interface SortStrategy {
    fun sortResponse(response: DefinitionsApiResponse): DefinitionsApiResponse
}