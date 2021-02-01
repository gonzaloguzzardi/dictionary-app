package com.guzzardi.dictionaryapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.guzzardi.dictionaryapp.databinding.SearchWordFragmentBinding
import com.guzzardi.dictionaryapp.viewmodels.SearchWordViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchWordFragment : Fragment() {

    private val searchWordViewModel: SearchWordViewModel by viewModels()

    private var binding: SearchWordFragmentBinding? = null

    companion object {
        private const val SAVED_SEARCHED_WORD = "SAVED_SEARCHED_WORD"
    }

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
        setUpInputEditText()
        setUpSearchButton()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding?.inputEditTextSearchWord?.text?.let { queryWord ->
            outState.putString(SAVED_SEARCHED_WORD, queryWord.toString())
        }
    }

    override fun onViewStateRestored(savedInstanceState: Bundle?) {
        super.onViewStateRestored(savedInstanceState)
        savedInstanceState?.getString(SAVED_SEARCHED_WORD, null)?.let { word ->
            setResultsTitle(word)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    private fun subscribeToLoadingChanges() {
        searchWordViewModel.loadingLiveData.observe(viewLifecycleOwner, { isLoading ->
            if (isLoading) {
                showLoading()
            } else {
                hideLoading()
            }
        })
    }

    private fun subscribeDefinitionsChanges() {
        searchWordViewModel.definitionsLiveData.observe(viewLifecycleOwner, { apiResponse ->
            binding?.definitionsRecyclerView?.setData(apiResponse.definitions ?: emptyList())
        })
    }

    private fun setUpSearchButton() {
        binding?.searchButton?.setOnClickListener {
            loadDefinitions()
        }
    }

    private fun setUpInputEditText() {
        binding?.run {
            inputEditTextSearchWord.addTextChangedListener {
                searchButton.isEnabled = !inputEditTextSearchWord.text.isNullOrBlank()
            }
        }
    }

    private fun showLoading() {
        binding?.run {
            definitionsRecyclerView.visibility = GONE
            loadingProgressBar.visibility = VISIBLE
            loadingProgressBar.show()
            searchButton.isEnabled = false
        }
    }

    private fun hideLoading() {
        binding?.run {
            loadingProgressBar.visibility = GONE
            definitionsRecyclerView.visibility = VISIBLE
            loadingProgressBar.hide()
            searchButton.isEnabled = true
        }
    }

    private fun loadDefinitions() {
        binding?.run {
            val queryText = inputEditTextSearchWord.text.toString()
            setResultsTitle(queryText)
            searchWordViewModel.getDefinitionsForWord(queryText)
        }
    }

    private fun setResultsTitle(word: String) {
        binding?.run {
            textViewSearchTitlePrefix.visibility = VISIBLE
            textViewResultsWordTitle.visibility = VISIBLE
            textViewResultsWordTitle.text = word
        }
    }
}