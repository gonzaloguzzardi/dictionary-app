package com.guzzardi.dictionaryapp.viewmodels.sorting

import com.guzzardi.dictionaryapp.viewmodels.sorting.SortType.LeastDownVoted
import com.guzzardi.dictionaryapp.viewmodels.sorting.SortType.LeastUpVoted
import com.guzzardi.dictionaryapp.viewmodels.sorting.SortType.MostDownVoted
import com.guzzardi.dictionaryapp.viewmodels.sorting.SortType.MostUpVoted
import com.guzzardi.dictionaryapp.viewmodels.sorting.strategies.LeastDownVotedSortStrategy
import com.guzzardi.dictionaryapp.viewmodels.sorting.strategies.LeastUpVotedSortStrategy
import com.guzzardi.dictionaryapp.viewmodels.sorting.strategies.MostDownVotedSortStrategy
import com.guzzardi.dictionaryapp.viewmodels.sorting.strategies.MostUpVotedSortStrategy
import com.guzzardi.dictionaryapp.viewmodels.sorting.strategies.SortStrategy

sealed class SortStrategyFactory {

    companion object {
        fun createSortStrategyByType(sortType: SortType): SortStrategy {
            return when (sortType) {
                MostUpVoted -> MostUpVotedSortStrategy()
                LeastUpVoted -> LeastUpVotedSortStrategy()
                MostDownVoted -> MostDownVotedSortStrategy()
                LeastDownVoted -> LeastDownVotedSortStrategy()
            }
        }
    }
}