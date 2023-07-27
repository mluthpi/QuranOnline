package com.example.quran.presentation.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.R
import com.example.quran.data.DetailSurahResponseItem
import com.example.quran.databinding.ActivityDetailSurahBinding
import com.example.quran.databinding.ActivityMainBinding

class DetailSurahActivity : AppCompatActivity() {

    private val binding by lazy { ActivityDetailSurahBinding.inflate(layoutInflater) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val number = intent.getIntExtra("nomor", 0)

    }

    private fun showSurahDetail(listDetailSurah: List<DetailSurahResponseItem>) {
        val detailAdapter = DetailSurahAdapter()
        detailAdapter.addItems(listDetailSurah)
        binding.rvDetailSurah.apply {
            layoutManager = LinearLayoutManager(
                this@DetailSurahActivity,
                RecyclerView.VERTICAL,
                false
            )
            adapter = detailAdapter
        }
    }
}