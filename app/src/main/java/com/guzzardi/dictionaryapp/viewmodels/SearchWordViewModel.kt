package com.guzzardi.dictionaryapp.viewmodels

import androidx.lifecycle.ViewModel
import com.guzzardi.dictionaryapp.data.repositories.DefinitionsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchWordViewModel @Inject constructor(private val repository: DefinitionsRepository) : ViewModel()