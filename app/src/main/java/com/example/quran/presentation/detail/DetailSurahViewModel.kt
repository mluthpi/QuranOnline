package com.example.quran.presentation.detail

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quran.data.DetailSurahResponse
import com.example.quran.data.DetailSurahResponseItem
import com.example.quran.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailSurahViewModel : ViewModel() {

    private val _listDetailSurah = MutableLiveData<List<DetailSurahResponseItem>>()
    val listDetailSurah : LiveData<List<DetailSurahResponseItem>> = _listDetailSurah

    fun getDetailSurah(nomor : Int) {
        val client = ApiConfig().getApiRest().getDetailSurah(nomor = nomor)
        client.enqueue(object : Callback<List<DetailSurahResponse>>{
            override fun onResponse(
                call: Call<DetailSurahResponse>,
                response: Response<DetailSurahResponseItem>
            ) {
                if (response.isSuccessful) {
                    _listDetailSurah.value = response.body()
                }
            }

            override fun onFailure(call: Call<DetailSurahResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

}