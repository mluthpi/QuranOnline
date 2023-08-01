package com.example.quran

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.data.SurahResponseItem
import com.example.quran.databinding.ActivityMainBinding
import com.example.quran.presentation.detail.DetailSurahActivity
import com.example.quran.presentation.SurahAdapter
import com.example.quran.presentation.surah.SurahViewModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }


    private val surahAdapter = SurahAdapter {
        val intent = Intent(this@MainActivity, DetailSurahActivity::class.java)
        intent.putExtra(DetailSurahActivity.KEY_NUMBER, it.nomor)
        startActivity(intent)
    }

    private lateinit var surahViewModel: SurahViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        surahViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()
        )[SurahViewModel::class.java]


        surahViewModel.getSurah()

        surahViewModel.listSurah.observe(this, { listSurah ->
            Log.d("TAG", "${listSurah.size}")
            showSurah(listSurah)
        })




    }

    private fun showSurah(listSurah: List<SurahResponseItem>) {
        surahAdapter.addItems(listSurah)
        binding.rvSurah.apply {
            layoutManager = LinearLayoutManager(
                this@MainActivity,
                RecyclerView.VERTICAL, false
            )
            adapter = surahAdapter
        }
    }
}