package com.example.homework_6.domain.usecases

import com.example.homework_6.data.NoteRepository
import com.example.homework_6.data.model.Note
import com.example.homework_6.data.NoteRepositoryImpl
import kotlinx.coroutines.flow.Flow


class GetNotesUseCase (
    private val noteRepository: NoteRepository = NoteRepositoryImpl()
    ) {
    operator fun invoke(): Flow<List<Note>> {
        return noteRepository.getNotes()
    }
}