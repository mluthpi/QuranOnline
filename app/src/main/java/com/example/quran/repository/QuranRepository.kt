package com.example.quran.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.example.quran.dao.QuranDao
import com.example.quran.dao.QuranRoomDatabase
import com.example.quran.model.QuranEntity
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class QuranRepository(application: Application) {
    private val mQuranDao: QuranDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = QuranRoomDatabase.getDatabase(application)
        mQuranDao = db.quranDao()
    }

    fun getAllSurah(): LiveData<List<QuranEntity>> = mQuranDao.getAllSurah()

    fun insert(quran: QuranEntity) {
        executorService.execute { mQuranDao.insert(quran)}
    }

    fun delete(quran: QuranEntity) {
        executorService.execute { mQuranDao.delete(quran)}
    }

    fun update(quran: QuranEntity) {
        executorService.execute { mQuranDao.update(quran)}
    }
}