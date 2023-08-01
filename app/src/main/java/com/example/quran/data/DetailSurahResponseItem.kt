package com.example.quran.data

import com.google.gson.annotations.SerializedName

data class DetailSurahResponseItem(

	@field:SerializedName("ar")
	val ar: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("nomor")
	val nomor: String? = null,

	@field:SerializedName("tr")
	val tr: String? = null
)
