package com.example.quran

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.quran.presentation.favorite.FavoriteViewModel
import com.example.quran.presentation.surat.DetailSurahViewModel
import com.example.quran.presentation.tafsir.DetailTafsirActivity
import com.example.quran.presentation.tafsir.DetailTafsirViewModel
import java.lang.IllegalArgumentException

class ViewModelFactory constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var INSTANCE : ViewModelFactory? = null
        @JvmStatic
        fun getInstance(application: Application) : ViewModelFactory {
            if(INSTANCE == null) {
            synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(application)
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DetailSurahViewModel::class.java)) {
            return DetailSurahViewModel(mApplication) as T
        } else if (modelClass.isAssignableFrom(DetailTafsirViewModel::class.java)) {
            return DetailTafsirViewModel(mApplication) as T
        } else if (modelClass.isAssignableFrom(FavoriteViewModel::class.java)) {
            return FavoriteViewModel(mApplication) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class : ${modelClass.name}")
    }

}