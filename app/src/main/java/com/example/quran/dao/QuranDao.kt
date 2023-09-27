package com.example.quran.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.quran.model.QuranEntity
import com.example.quran.model.TafsirEntity


@Dao
interface QuranDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(quran: QuranEntity)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tafsir: TafsirEntity)

    @Update
    fun update(quran: QuranEntity)
    @Update
    fun update(tafsir: TafsirEntity)

    @Delete
    fun delete(quran: QuranEntity)
    @Delete
    fun delete(tafsir: TafsirEntity)

    @Query("SELECT * from quranentity ORDER BY nama ASC")
    fun getAllSurah(): LiveData<List<QuranEntity>>
    @Query("SELECT * from tafsirentity ORDER BY nama ASC")
    fun getAllTafsir(): LiveData<List<TafsirEntity>>
}