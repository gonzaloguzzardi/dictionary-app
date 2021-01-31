package com.guzzardi.dictionaryapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.guzzardi.dictionaryapp.databinding.SearchWordFragmentBinding
import com.guzzardi.dictionaryapp.viewmodels.SearchWordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchWordFragment : Fragment() {

    private val searchWordViewModel: SearchWordViewModel by viewModels()

    private var binding: SearchWordFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchWordFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subscribeToLoadingChanges()
        subscribeDefinitionsChanges()

        loadDefinitions()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun subscribeToLoadingChanges() {
        searchWordViewModel.loadingLiveData.observe(viewLifecycleOwner, { isLoading ->
            if (isLoading) {
                binding?.loadingProgressBar?.visibility = VISIBLE
            } else {
                binding?.loadingProgressBar?.visibility = GONE
            }
        })
    }

    private fun subscribeDefinitionsChanges() {
        searchWordViewModel.definitionsLiveData.observe(viewLifecycleOwner, { apiResponse ->
            binding?.definitionsRecyclerView?.setData(apiResponse.definitions ?: emptyList())
        })
    }

    private fun loadDefinitions() {
        searchWordViewModel.getDefinitionsForWord("Hello")
    }
}