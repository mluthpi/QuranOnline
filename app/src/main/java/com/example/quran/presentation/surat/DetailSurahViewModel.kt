package com.example.quran.presentation.surat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quran.data.DetailSurahResponseItem
import com.example.quran.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailSurahViewModel : ViewModel() {

    private val _listDetailSurah = MutableLiveData<List<DetailSurahResponseItem>>()
    val listDetailSurah : LiveData<List<DetailSurahResponseItem>> = _listDetailSurah

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getDetailSurah(nomor : String) {
        _isLoading.value = true
        val client = ApiConfig().getApiRest().getDetailSurah(nomor = nomor)
        client.enqueue(object : Callback<List<DetailSurahResponseItem>>{
            override fun onResponse(
                call: Call<List<DetailSurahResponseItem>>,
                response: Response<List<DetailSurahResponseItem>>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _listDetailSurah.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<DetailSurahResponseItem>>, t: Throwable) {
                _isLoading.value = false
            }

        })
    }

}