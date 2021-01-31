package com.guzzardi.dictionaryapp.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.guzzardi.dictionaryapp.databinding.SearchWordFragmentBinding
import com.guzzardi.dictionaryapp.viewmodels.SearchWordViewModel

class SearchWordFragment : Fragment() {

    private val viewModel: SearchWordViewModel by viewModels()

    private var binding: SearchWordFragmentBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = SearchWordFragmentBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}