package com.example.quran.presentation.tafsir

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.quran.data.TafsirResponse
import com.example.quran.databinding.ActivityTafsirDetailBinding

class TafsirDetailActivity : AppCompatActivity() {

    private lateinit var vm: TafsirViewModel

    private val binding by lazy { ActivityTafsirDetailBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val nomer = intent.getIntExtra(KEY_NUMBER, 0)

        initView()
        initViewModel()
        observeViewModel(nomer)
    }

    private fun initView() {
        with(binding) {
            toolbar.icBack.setOnClickListener { finish() }
        }
    }

    private fun initViewModel() {
        vm = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        )[TafsirViewModel::class.java]
    }

    private fun observeViewModel(nomer: Int) {
        vm.getTafsir(nomer)
        vm.tafsirDetail.observe(this) { tafsirResponse ->
            setupView(data = tafsirResponse)
        }
    }

    private fun setupView(data: TafsirResponse?) {
        with(binding) {
            data?.let {
                toolbar.tvTitle.text = data.namaLatin
                tvName.text = data.nama
                tvLatinName.text = data.namaLatin
                tvArti.text = data.arti
                tvDescription.text = data.deskripsi
            }
        }
    }

    companion object {
        const val KEY_NUMBER = "KEY_NUMBER"
    }
}