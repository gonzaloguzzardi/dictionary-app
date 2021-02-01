package com.guzzardi.dictionaryapp.viewmodels.sorting

enum class SortType {
    MostUpVoted,
    LeastUpVoted,
    MostDownVoted,
    LeastDownVoted;

    companion object {
        fun fromInt(value: Int): SortType =
            values().firstOrNull { it.ordinal == value } ?: MostUpVoted
    }
}