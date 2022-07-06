package com.example.homework_6.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Notes")
data class NoteEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val text: String
    )