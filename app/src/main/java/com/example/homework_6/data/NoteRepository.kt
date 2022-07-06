package com.example.homework_6.data

import com.example.homework_6.data.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    fun getNotes(): Flow<List<Note>>
    suspend fun addNote(text: String)
    suspend fun deleteNote(id: Int)
    suspend fun searchNote(text: String): List<Note>
}