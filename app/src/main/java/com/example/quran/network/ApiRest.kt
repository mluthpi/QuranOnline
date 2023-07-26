package com.example.quran.network

import com.example.quran.data.DetailSurahResponse
import com.example.quran.data.SurahResponse
import com.example.quran.data.SurahResponseItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiRest {
    @GET("/99c279bb173a6e28359c/data")
    fun getListSurah(): Call<List<SurahResponseItem>>

    @GET("/99c279bb173a6e28359c/surat/{nomor}")
    fun getDetailSurah(
        @Path("nomor") nomor: String
    ): Call<ArrayList<DetailSurahResponse>>

//    @GET("place/nearbysearch/json")
//    fun getDataResult(
//        @Query("key") key: String,
//        @Query("keyword") keyword: String,
//        @Query("location") location: String,
//        @Query("rankby") rankby: String
//    ): Call<ModelResultNearby>
}