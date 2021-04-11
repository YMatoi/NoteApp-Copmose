package com.github.ymatoi.noteapp.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Note(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "text") val text: String
)