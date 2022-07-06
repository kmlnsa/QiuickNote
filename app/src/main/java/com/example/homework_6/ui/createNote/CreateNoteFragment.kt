package com.example.homework_6.ui.createNote

import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.R
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.homework_6.data.model.Note
import com.example.homework_6.databinding.FragmentCreateNoteBinding

class CreateNoteFragment:Fragment(){

    private lateinit var binding: FragmentCreateNoteBinding
    private val viewModel: CreateNoteViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCreateNoteBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.fab.setOnClickListener {
            val text = binding.enterText.text.toString()
            if (text.isNotBlank()) {
                viewModel.addNote(text)
                findNavController().navigateUp()
            }
        }

        binding.apply {
            toolBar.setNavigationOnClickListener(){
                findNavController().popBackStack()
            }
        }
    }
}