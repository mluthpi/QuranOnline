package com.example.quran.data


import com.google.gson.annotations.SerializedName

data class TafsirResponse(
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
    @SerializedName("status")
    val status: Boolean? = null,
    @SerializedName("surat_sebelumnya")
    val suratSebelumnya: Boolean? = null,
    @SerializedName("surat_selanjutnya")
    val suratSelanjutnya: SuratSelanjutnya? = null,
    @SerializedName("tafsir")
    val tafsir: List<Tafsir>? = null,
    @SerializedName("tempat_turun")
    val tempatTurun: String? = null
) {
    data class Tafsir(
        @SerializedName("ayat")
        val ayat: Int? = null,
        @SerializedName("id")
        val id: Int? = null,
        @SerializedName("surah")
        val surah: Int? = null,
        @SerializedName("tafsir")
        val tafsir: String? = null
    )

    data class SuratSelanjutnya(
        @SerializedName("arti")
        val arti: String? = null,
        @SerializedName("audio")
        val audio: String? = null,
        @SerializedName("deskripsi")
        val deskripsi: String? = null,
        @SerializedName("id")
        val id: Int? = null,
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
}