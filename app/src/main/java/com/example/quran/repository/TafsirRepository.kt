package com.example.quran.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.quran.dao.QuranDao
import com.example.quran.dao.QuranRoomDatabase
import com.example.quran.model.TafsirEntity
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class TafsirRepository(application: Application) {
    private val mTafsirDao: QuranDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = QuranRoomDatabase.getDatabase(application)
        mTafsirDao = db.quranDao()
    }

    fun getAllTafsir(): LiveData<List<TafsirEntity>> = mTafsirDao.getAllTafsir()

    fun insert(tafsir: TafsirEntity) {
        executorService.execute { mTafsirDao.insert(tafsir)}
    }

    fun delete(tafsir: TafsirEntity) {
        executorService.execute { mTafsirDao.delete(tafsir)}
    }

    fun update(tafsir: TafsirEntity) {
        executorService.execute { mTafsirDao.update(tafsir) }
    }
}