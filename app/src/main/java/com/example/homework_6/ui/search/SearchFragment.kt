package com.example.homework_6.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.homework_6.NoteAdapter
import com.example.homework_6.databinding.FragmentSearchBinding

class SearchFragment(): Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private val searchNoteAdapter = NoteAdapter()
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.apply {
            toolBarSearch.setNavigationOnClickListener() {
                findNavController().popBackStack()
            }
        }

        binding.searchText.addTextChangedListener{
            viewModel.searchNote(it.toString())

        }

        viewModel.liveData.observe(viewLifecycleOwner){
            searchNoteAdapter.submitList(it)
        }

        binding.recycler.apply {
            adapter = searchNoteAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }
}