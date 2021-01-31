package com.guzzardi.dictionaryapp.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.guzzardi.dictionaryapp.data.model.DefinitionsApiResponse
import com.guzzardi.dictionaryapp.data.repositories.DefinitionsRepository
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

    private val exceptionHandler = CoroutineExceptionHandler { _, _ ->
        loadingLiveData.postValue(false)
    }

    fun getDefinitionsForWord(word: String) = viewModelScope.launch(exceptionHandler) {
        loadingLiveData.postValue(true)
        repository.getDefinitionsForWord(word).collect { apiResponse ->
            definitionsLiveData.postValue(apiResponse)
        }
        loadingLiveData.postValue(false)
    }
}