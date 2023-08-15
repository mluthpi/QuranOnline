package com.example.quran.presentation.surat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quran.data.AyatItem
import com.example.quran.data.DetailSurahResponse
import com.example.quran.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailSurahViewModel : ViewModel() {

    private val _listDetailSurah = MutableLiveData<List<AyatItem>>()
    val listDetailSurah : LiveData<List<AyatItem>> = _listDetailSurah

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getDetailSurah(nomor : String) {
        _isLoading.value = true
        val client = ApiConfig().getApiRest().getDetailSurah(nomor = nomor)
        client.enqueue(object : Callback<DetailSurahResponse>{
            override fun onResponse(
                call: Call<DetailSurahResponse>,
                response: Response<DetailSurahResponse>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _listDetailSurah.value = response.body()?.ayat ?: emptyList()
                }
            }

            override fun onFailure(call: Call<DetailSurahResponse>, t: Throwable) {
                _isLoading.value = false
            }


        })
    }

}