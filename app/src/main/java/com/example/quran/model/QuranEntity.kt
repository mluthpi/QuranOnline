package com.example.quran.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class QuranEntity(
    @PrimaryKey(autoGenerate = true)
    val nomor : Int? = 0,

    val namaLatin : String? = null,

    val nama : String? = null,

    val arti : String? = null,
)
