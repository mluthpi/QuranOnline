package com.example.quran.presentation.surat

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quran.data.SurahResponseItem
import com.example.quran.network.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SurahViewModel : ViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading get() = _isLoading

    private val _listSurah = MutableLiveData<List<SurahResponseItem>>()
    val listSurah: LiveData<List<SurahResponseItem>> = _listSurah

    fun getSurah() {
        _isLoading.value = true
        val client = ApiConfig().getApiRest().getListSurah()
        client.enqueue(object : Callback<List<SurahResponseItem>> {
            override fun onResponse(
                call: Call<List<SurahResponseItem>>,
                response: Response<List<SurahResponseItem>>
            ) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _listSurah.value = response.body()
                } else {
                    _listSurah.value = emptyList()
                }
            }

            override fun onFailure(call: Call<List<SurahResponseItem>>, t: Throwable) {
                _isLoading.value = false
            }
        })
    }

}