package com.example.quran.presentation.favorite

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.quran.model.QuranEntity
import com.example.quran.model.TafsirEntity
import com.example.quran.repository.QuranRepository
import com.example.quran.repository.TafsirRepository

class FavoriteViewModel(application: Application) : AndroidViewModel(application) {
    private val quranRepository = QuranRepository(application)
    private val tafsirRepository = TafsirRepository(application)

    fun getFavoriteQuran() : LiveData<List<QuranEntity>> = quranRepository.getAllSurah()
    fun getFavoriteTafsir() : LiveData<List<TafsirEntity>> = tafsirRepository.getAllTafsir()
}