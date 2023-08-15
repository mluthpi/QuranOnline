package com.example.quran.data


import com.google.gson.annotations.SerializedName

data class SurahResponse(
    @SerializedName("arti")
    val arti: String? = null,
    @SerializedName("audio")
    val audio: String? = null,
    @SerializedName("deskripsi")
    val deskripsi: String? = null,
    @SerializedName("jumlah_ayat")
    val jumlahAyat: Int? = null,
    @SerializedName("nama")
    val nama: String? = null,
    @SerializedName("nama_latin")
    val namaLatin: String? = null,
    @SerializedName("nomor")
    val nomor: Int? = null,
    @SerializedName("tempat_turun")
    val tempatTurun: String? = null
)