package com.example.quran.presentation.surat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quran.data.SurahResponse
import com.example.quran.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SurahViewModel : ViewModel() {

    companion object {
        private const val TAG = "TEST DEBUG"
    }

    private val _listSurah = MutableLiveData<List<SurahResponse>>()
    val listSurah: LiveData<List<SurahResponse>> = _listSurah

    fun getSurah() {
        val client = ApiConfig().getApiRest().getListSurah()
        client.enqueue(object : Callback<List<SurahResponse>> {
            override fun onResponse(
                call: Call<List<SurahResponse>>,
                response: Response<List<SurahResponse>>
            ) {
                if (response.isSuccessful) {
                    _listSurah.value = response.body()
                } else {
                    _listSurah.value = emptyList()
                }
            }

            override fun onFailure(call: Call<List<SurahResponse>>, t: Throwable) {

            }
        })
    }

}