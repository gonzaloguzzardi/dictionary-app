package com.guzzardi.dictionaryapp.viewmodels.sorting

enum class SortType(val value: Int) {
    MostUpVoted(0),
    LeastUpVoted(1),
    MostDownVoted(2),
    LeastDownVoted(3);

    companion object {
        fun fromInt(value: Int): SortType =
            values().firstOrNull { it.value == value } ?: MostUpVoted
    }
}