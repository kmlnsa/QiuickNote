package com.example.homework_6.domain.usecases

import com.example.homework_6.data.NoteRepository
import com.example.homework_6.data.NoteRepositoryImpl
import com.example.homework_6.data.model.Note


class SearchNoteUseCase(
    private val noteRepository: NoteRepository = NoteRepositoryImpl()
    ) {
    suspend operator fun invoke(text: String): List<Note> {
        return noteRepository.searchNote(text)
    }
}