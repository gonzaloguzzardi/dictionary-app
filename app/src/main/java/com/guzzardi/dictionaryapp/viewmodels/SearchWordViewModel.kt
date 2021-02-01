package com.guzzardi.dictionaryapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guzzardi.dictionaryapp.data.model.DefinitionsApiResponse
import com.guzzardi.dictionaryapp.data.repositories.DefinitionsRepository
import com.guzzardi.dictionaryapp.viewmodels.sorting.SortStrategyFactory
import com.guzzardi.dictionaryapp.viewmodels.sorting.SortType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchWordViewModel @Inject constructor(private val repository: DefinitionsRepository) :
    ViewModel() {
    val loadingLiveData = MutableLiveData<Boolean>()
    val definitionsLiveData = MutableLiveData<DefinitionsApiResponse>()

    var sortType = SortType.MostUpVoted

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        loadingLiveData.postValue(false)
    }

    fun getDefinitionsForWord(word: String) = viewModelScope.launch(exceptionHandler) {
        loadingLiveData.postValue(true)
        repository.getDefinitionsForWord(word).collect { apiResponse ->
            val sortedResponse = sortResponse(apiResponse, sortType)
            definitionsLiveData.postValue(sortedResponse)
        }
        loadingLiveData.postValue(false)
    }

    fun sortResults(sortType: SortType) {
        definitionsLiveData.value?.let { response ->
            definitionsLiveData.postValue(sortResponse(response, sortType))
        }
    }

    private fun sortResponse(response: DefinitionsApiResponse, sortType: SortType): DefinitionsApiResponse {
        val sortStrategy = SortStrategyFactory.createSortStrategyByType(sortType)
        return sortStrategy.sortResponse(response)
    }
}