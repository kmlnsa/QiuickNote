package com.example.homework_6.data

import com.example.homework_6.App
import com.example.homework_6.data.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

class RoomDataSource(
    private val database: NoteDataBase = App.instance.database
) {
    private val dao inline get() = database.dao()

    fun getNotes(): Flow<List<NoteEntity>> {
        return dao.getAll()
    }

    suspend fun addNote(
        text: String
    ){
        dao.addNote(NoteEntity(text = text))
    }

    suspend fun deleteNote(id: Int) {
        dao.deleteNote(id)
    }

    suspend fun searchNote(text: String): List<NoteEntity>{
        return dao.searchNote(text)
    }
}