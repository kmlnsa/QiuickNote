package com.example.homework_6.ui.createNote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_6.domain.usecases.AddNotesUseCase
import kotlinx.coroutines.launch

class CreateNoteViewModel(
    private val addNotesUseCase: AddNotesUseCase = AddNotesUseCase()
):ViewModel() {

    fun addNote(text: String){
        viewModelScope.launch {
            addNotesUseCase(text)
        }
    }
}