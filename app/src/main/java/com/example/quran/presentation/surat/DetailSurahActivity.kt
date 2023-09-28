package com.example.quran.presentation.surat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.ViewModelFactory
import com.example.quran.data.AyatItem
import com.example.quran.databinding.ActivityDetailSurahBinding

class DetailSurahActivity : AppCompatActivity() {

    private val viewModel: DetailSurahViewModel by viewModels {
        ViewModelFactory(application)
    }

    private val binding by lazy { ActivityDetailSurahBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val number = intent.getIntExtra(KEY_NUMBER, 0)
        observeDetailSurah(number.toString())
    }

    private fun observeDetailSurah(number: String) = with(binding) {
        viewModel.getDetailSurah(number)
        viewModel.listDetailSurah.observe(this@DetailSurahActivity) {
            showSurahDetail(it)
        }

        viewModel.isLoading.observe(this@DetailSurahActivity) { isLoading ->
            if (isLoading) progressbar.visibility = View.VISIBLE
            else progressbar.visibility = View.GONE
        }
    }

    private fun showSurahDetail(listDetailSurah: List<AyatItem>) {
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

    companion object {
        const val KEY_NUMBER = "KEY_NUMBER"
    }
}