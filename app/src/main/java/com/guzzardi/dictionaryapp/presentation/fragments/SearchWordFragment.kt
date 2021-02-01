package com.guzzardi.dictionaryapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo.IME_ACTION_DONE
import android.view.inputmethod.EditorInfo.IME_ACTION_NEXT
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.TextView.OnEditorActionListener
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.guzzardi.dictionaryapp.R
import com.guzzardi.dictionaryapp.databinding.SearchWordFragmentBinding
import com.guzzardi.dictionaryapp.presentation.utils.KeyboardUtils
import com.guzzardi.dictionaryapp.viewmodels.SearchWordViewModel
import com.guzzardi.dictionaryapp.viewmodels.sorting.SortType
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
@Suppress("TooManyFunctions")
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
        setUpSortOptionsSpinner()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding?.editTextSearchWord?.text?.let { queryWord ->
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
        binding?.searchButton?.apply {
            isEnabled = !binding?.editTextSearchWord?.text.isNullOrBlank()
            setOnClickListener {
                setResultsTitle(binding?.editTextSearchWord?.text.toString())
                loadDefinitions()
                closeKeyboard()
            }
        }
    }

    private fun setUpInputEditText() {
        binding?.run {
            editTextSearchWord.addTextChangedListener {
                searchButton.isEnabled = !editTextSearchWord.text.isNullOrBlank()
            }

            editTextSearchWord.setImeActionLabel(
                resources.getString(R.string.action_search),
                IME_ACTION_DONE
            )
            editTextSearchWord.setOnEditorActionListener(OnEditorActionListener { _, actionId, event ->
                if (actionId == IME_ACTION_DONE || actionId == IME_ACTION_NEXT) {
                    loadDefinitions()
                    closeKeyboard()
                    return@OnEditorActionListener true
                }
                false
            })
        }
    }

    private fun setUpSortOptionsSpinner() {
        binding?.run {
            resultsSortSpinner.onItemSelectedListener = object : OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    v: View?,
                    position: Int,
                    arg3: Long
                ) {
                    val sortType = SortType.fromInt(position)
                    searchWordViewModel.sortType = sortType
                    searchWordViewModel.sortResults(sortType)
                }

                override fun onNothingSelected(adapterView: AdapterView<*>?) { /* No-op. */ }
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
        val queryText = binding?.editTextSearchWord?.text.toString()
        searchWordViewModel.getDefinitionsForWord(queryText)
    }

    private fun setResultsTitle(word: String) {
        binding?.run {
            textViewSearchTitlePrefix.visibility = VISIBLE
            textViewResultsWordTitle.visibility = VISIBLE
            textViewResultsWordTitle.text = word
        }
    }

    private fun closeKeyboard() {
        binding?.editTextSearchWord?.let { view ->
            context?.let { KeyboardUtils.hideKeyboardFrom(it, view) }
        }
    }
}