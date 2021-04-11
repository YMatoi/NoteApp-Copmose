package com.github.ymatoi.noteapp.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.github.ymatoi.noteapp.data.dao.NoteDao
import com.github.ymatoi.noteapp.data.entity.Note

@Database(entities = [Note::class], version = 1)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}