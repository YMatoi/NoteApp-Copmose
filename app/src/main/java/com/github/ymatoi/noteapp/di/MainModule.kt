package com.github.ymatoi.noteapp.di

import androidx.room.Room
import com.github.ymatoi.noteapp.data.database.NoteDatabase
import org.koin.dsl.module
import org.koin.experimental.builder.single

val mainModule = module {
    single { Room.databaseBuilder(get(), NoteDatabase::class.java, "database").build() }
    factory { get<NoteDatabase>().noteDao() }
}