package com.example.quran.network


import com.example.quran.data.DetailSurahResponse
import com.example.quran.data.SurahResponseItem
import com.example.quran.data.TafsirResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiRest {
    @GET("surat")
    fun getListSurah(): Call<List<SurahResponseItem>>

    @GET("surat/{nomor}")
    fun getDetailSurah(
        @Path("nomor") nomor: String
    ): Call<DetailSurahResponse>

    @GET("tafsir/{nomor}")
    fun getTafsir(@Path("nomor") nomor: Int): Call<TafsirResponse>
}