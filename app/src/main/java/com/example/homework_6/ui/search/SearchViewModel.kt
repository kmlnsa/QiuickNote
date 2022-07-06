package com.example.homework_6.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework_6.data.model.Note
import com.example.homework_6.domain.usecases.SearchNoteUseCase
import kotlinx.coroutines.launch

class SearchViewModel (
    private val searchNoteUseCase: SearchNoteUseCase = SearchNoteUseCase()
): ViewModel() {

    private val _liveData = MutableLiveData<List<Note>?>()
    val liveData: LiveData<List<Note>?> = _liveData

    fun searchNote(text: String){
        viewModelScope.launch {
            _liveData.value = searchNoteUseCase(text)
        }
    }
}