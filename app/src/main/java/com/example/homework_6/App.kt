package com.example.homework_6

import android.app.Application
import androidx.room.Room
import com.example.homework_6.data.NoteDataBase

class App : Application(){
    companion object{
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
    val database by lazy {
        Room.databaseBuilder(
            this,
            NoteDataBase::class.java,
            "notes.db"
        ).build()
    }
}
