package com.example.quran.presentation.tafsir

import android.app.Application
import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.quran.data.TafsirResponse
import com.example.quran.model.TafsirEntity
import com.example.quran.network.ApiConfig
import com.example.quran.repository.TafsirRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailTafsirViewModel(application: Application): ViewModel() {
    private val mTafsirRepository : TafsirRepository = TafsirRepository(application)

    private val _listDetailTafsir = MutableLiveData<List<TafsirResponse.Tafsir>>()
    val listDetailTafsir: LiveData<List<TafsirResponse.Tafsir>> = _listDetailTafsir

    private val _dataDetail = MutableLiveData<TafsirResponse>()
    val dataDetail : LiveData<TafsirResponse> = _dataDetail

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    fun getDetailTafsir(nomor: Int) {
        val client = ApiConfig().getApiRest().getTafsir(nomor = nomor)
        client.enqueue(object : Callback<TafsirResponse> {
            override fun onResponse(
                call: Call<TafsirResponse>,
                response: Response<TafsirResponse>
            ) {
                if (response.isSuccessful) {
                    _listDetailTafsir.value = response.body()?.tafsir?: emptyList()
                    _dataDetail.value = response.body()
                } else {
                    Log.e(TAG, "onResponse: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<TafsirResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message.toString()}")
            }
        })
    }

    fun insertToDB(tafsir : TafsirEntity) {
        mTafsirRepository.insert(tafsir)
    }

    fun deleteToDB(tafsir: TafsirEntity) {
        mTafsirRepository.delete(tafsir)
    }

    fun getFavoriteTafsir() : LiveData<List<TafsirEntity>> = mTafsirRepository.getAllTafsir()
}