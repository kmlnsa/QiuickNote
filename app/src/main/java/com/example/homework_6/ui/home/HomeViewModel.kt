package com.example.homework_6.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.homework_6.domain.usecases.DeleteNotesUseCase
import com.example.homework_6.domain.usecases.GetNotesUseCase
import kotlinx.coroutines.launch

class HomeViewModel(
    getNotesUseCase: GetNotesUseCase = GetNotesUseCase(),
    private val deleteNotesUseCase: DeleteNotesUseCase = DeleteNotesUseCase(),
) : ViewModel() {

    val liveData = getNotesUseCase().asLiveData()

    fun deleteNote(position: Int) {
        viewModelScope.launch {
            liveData.value?.get(position)?.let { note ->
                deleteNotesUseCase(note.id)
            }
        }
    }
}