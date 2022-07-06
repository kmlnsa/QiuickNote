package com.example.homework_6.data

import com.example.homework_6.data.model.Note
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class NoteRepositoryImpl(
    private val roomDataSource: RoomDataSource = RoomDataSource()
) : NoteRepository {

    override suspend fun addNote(text: String) {
        roomDataSource.addNote(text)
    }

    override fun getNotes(): Flow<List<Note>> {
        return roomDataSource.getNotes()
            .map { notes ->
                notes.map {
                    Note(it.id, it.text)
                }
            }
    }

    override suspend fun deleteNote(id: Int) {
        return roomDataSource.deleteNote(id)
    }

    override suspend fun searchNote(text: String): List<Note> {
        return roomDataSource.searchNote(text)
            .map {
                Note(it.id, it.text)
            }
    }
}