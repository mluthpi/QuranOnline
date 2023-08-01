package com.example.quran.network

import com.example.quran.data.DetailSurahResponseItem
import com.example.quran.data.SurahResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRest {
    @GET("data")
    fun getListSurah(): Call<List<SurahResponseItem>>

    @GET("surat/{nomor}")
    fun getDetailSurah(
        @Path("nomor") nomor: String
    ): Call<List<DetailSurahResponseItem>>
}