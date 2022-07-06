package com.example.homework_6.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.homework_6.data.entity.NoteEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addNote(note: NoteEntity)

    @Query("SELECT * FROM notes ORDER BY id DESC")
    fun getAll(): Flow<List<NoteEntity>>

    @Query("DELETE FROM notes WHERE id = :id")
    suspend fun deleteNote(id: Int)

    @Query("SELECT * FROM notes WHERE text LIKE '%' || :text || '%'")
    suspend fun searchNote(text: String): List<NoteEntity>
}