package com.example.quran.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class TafsirEntity(
    @PrimaryKey(autoGenerate = true)
    val nomor : Int? = 0,

    val namalatin : String? = null,

    val nama : String? = null,

    val arti : String? = null,
)
