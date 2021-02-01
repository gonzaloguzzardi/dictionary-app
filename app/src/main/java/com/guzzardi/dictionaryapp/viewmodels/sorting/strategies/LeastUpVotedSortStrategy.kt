package com.guzzardi.dictionaryapp.viewmodels.sorting.strategies

import com.guzzardi.dictionaryapp.data.model.DefinitionsApiResponse

class LeastUpVotedSortStrategy :SortStrategy {
    override fun sortResponse(response: DefinitionsApiResponse): DefinitionsApiResponse {
        val list = response.definitions ?: return response
        val sortedList = list.sortedBy { it.upVotes }
        return DefinitionsApiResponse(sortedList)
    }
}