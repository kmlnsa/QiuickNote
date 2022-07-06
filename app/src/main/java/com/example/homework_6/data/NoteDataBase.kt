package com.example.homework_6.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework_6.data.entity.NoteEntity

@Database(
    entities = [NoteEntity::class],
    version = 1)
abstract class NoteDataBase: RoomDatabase() {

    abstract fun dao(): NoteDAO
}