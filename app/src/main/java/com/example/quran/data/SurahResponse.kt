package com.example.quran.data

import com.google.gson.annotations.SerializedName

data class SurahResponse(

	@field:SerializedName("SurahResponse")
	val surahResponse: List<SurahResponseItem?>? = null
)

data class SurahResponseItem(

	@field:SerializedName("keterangan")
	val keterangan: String? = null,

	@field:SerializedName("rukuk")
	val rukuk: String? = null,

	@field:SerializedName("nama")
	val nama: String? = null,

	@field:SerializedName("ayat")
	val ayat: Int? = null,

	@field:SerializedName("urut")
	val urut: String? = null,

	@field:SerializedName("arti")
	val arti: String? = null,

	@field:SerializedName("asma")
	val asma: String? = null,

	@field:SerializedName("audio")
	val audio: String? = null,

	@field:SerializedName("type")
	val type: String? = null,

	@field:SerializedName("nomor")
	val nomor: String? = null
)
