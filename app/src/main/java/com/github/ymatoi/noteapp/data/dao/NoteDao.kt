package com.github.ymatoi.noteapp.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.github.ymatoi.noteapp.data.entity.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert
    fun insertAll(vararg note: Note)
    @Delete
    fun delete(note: Note)
    @Query("select * from note")
    fun getAll(): LiveData<List<Note>>
}