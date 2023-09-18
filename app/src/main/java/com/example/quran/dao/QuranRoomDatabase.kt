package com.example.quran.dao

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.quran.model.QuranEntity
import com.example.quran.model.TafsirEntity


@Database(entities = [QuranEntity::class, TafsirEntity::class], version = 4)
abstract class QuranRoomDatabase : RoomDatabase() {
    abstract fun quranDao(): QuranDao

    companion object {
        @Volatile
        private var INSTANCE: QuranRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context) : QuranRoomDatabase {
            if (INSTANCE == null) {
                synchronized(QuranRoomDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        QuranRoomDatabase::class.java, "quran_database")
                        .build()
                }
            }
            return INSTANCE as QuranRoomDatabase
        }
    }
}