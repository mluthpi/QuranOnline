package com.example.quran.network

import com.example.quran.data.DetailSurahResponseItem
import com.example.quran.data.SurahResponse
import com.example.quran.data.TafsirResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRest {
    @GET("surat")
    fun getListSurah(): Call<List<SurahResponse>>

    @GET("surat/{nomor}")
    fun getDetailSurah(
        @Path("nomor") nomor: String
    ): Call<List<DetailSurahResponseItem>>

    @GET("tafsir/{nomor}")
    fun getTafsir(@Path("nomor") nomor: Int): Call<TafsirResponse>
}