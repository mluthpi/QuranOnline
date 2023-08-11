package com.example.quran.presentation.detail.ui.detail.surat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.data.DetailSurahResponseItem
import com.example.quran.databinding.ListDetailSuratBinding

class DetailSurahAdapter() : RecyclerView.Adapter<DetailSurahAdapter.DetailSurahHolder>() {

    private val detailSurahList = mutableListOf<DetailSurahResponseItem>()

    fun addItems(detailSurahList: List<DetailSurahResponseItem>) {
        this.detailSurahList.clear()
        this.detailSurahList.addAll(detailSurahList)
        notifyDataSetChanged()
    }

    class DetailSurahHolder(private val binding: ListDetailSuratBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(detailSurah: DetailSurahResponseItem) {
            with(binding) {
                tvAyatNumber.text = detailSurah.nomor
                tvDetailHijaiyah.text = detailSurah.ar
                tvLatin.text = detailSurah.tr
                tvTerjemahan.text = detailSurah.id
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailSurahHolder {
        val detailSurahBinding = ListDetailSuratBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DetailSurahHolder(detailSurahBinding)
    }

    override fun getItemCount(): Int = detailSurahList.size

    override fun onBindViewHolder(holder: DetailSurahHolder, position: Int) {
        val detailSurahItem = detailSurahList[position]
        holder.bind(detailSurahItem)
    }

}