package com.example.homework_6.domain.usecases

import com.example.homework_6.data.NoteRepository
import com.example.homework_6.data.NoteRepositoryImpl


class AddNotesUseCase (
    private val noteRepository: NoteRepository = NoteRepositoryImpl()
){
    suspend operator fun invoke(text: String) {
         noteRepository.addNote(text)
    }
}