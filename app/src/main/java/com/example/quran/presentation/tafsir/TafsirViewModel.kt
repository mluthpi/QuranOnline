package com.example.quran.presentation.tafsir

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quran.data.SurahResponse
import com.example.quran.data.TafsirResponse
import com.example.quran.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TafsirViewModel : ViewModel() {

    private val _tafsirDetail = MutableLiveData<TafsirResponse?>()
    val tafsirDetail get() = _tafsirDetail

    fun getTafsir(nomer: Int) {
        val client = ApiConfig().getApiRest().getTafsir(nomer)
        client.enqueue(object : Callback<TafsirResponse> {
            override fun onResponse(
                call: Call<TafsirResponse>,
                response: Response<TafsirResponse>
            ) {
                if (response.isSuccessful) {
                    if (response.body() != null) {
                        _tafsirDetail.value = response.body()
                    } else _tafsirDetail.value = null
                } else {
                    _tafsirDetail.value = null
                }
            }

            override fun onFailure(call: Call<TafsirResponse>, t: Throwable) {

            }
        })
    }
}