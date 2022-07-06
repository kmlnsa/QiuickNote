package com.example.homework_6.domain.usecases

import com.example.homework_6.data.NoteRepository
import com.example.homework_6.data.NoteRepositoryImpl

class DeleteNotesUseCase(
    private val noteRepository: NoteRepository = NoteRepositoryImpl()
) {
    suspend operator fun invoke(id: Int){
         noteRepository.deleteNote(id)
    }
}