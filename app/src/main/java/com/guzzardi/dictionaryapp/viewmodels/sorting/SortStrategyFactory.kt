package com.guzzardi.dictionaryapp.viewmodels.sorting

import com.guzzardi.dictionaryapp.viewmodels.sorting.SortType.*
import com.guzzardi.dictionaryapp.viewmodels.sorting.strategies.*

sealed class SortStrategyFactory {

    companion object {
        fun createSortStrategyByType(sortType: SortType): SortStrategy {
            return when(sortType) {
                MostUpVoted -> MostUpVotedSortStrategy()
                LeastUpVoted -> LeastUpVotedSortStrategy()
                MostDownVoted -> MostDownVotedSortStrategy()
                LeastDownVoted -> LeastDownVotedSortStrategy()
            }
        }
    }
}