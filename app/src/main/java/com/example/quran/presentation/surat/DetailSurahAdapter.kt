package com.example.quran.presentation.surat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.data.AyatItem
import com.example.quran.databinding.ListDetailSuratBinding

class DetailSurahAdapter : RecyclerView.Adapter<DetailSurahAdapter.DetailSurahHolder>() {

    private val detailSurahList = mutableListOf<AyatItem>()

    fun addItems(detailSurahList: List<AyatItem>) {
        this.detailSurahList.clear()
        this.detailSurahList.addAll(detailSurahList)
        notifyDataSetChanged()
    }

    class DetailSurahHolder(private val binding: ListDetailSuratBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(detailSurah: AyatItem) {
            with(binding) {
                tvAyatNumber.text = detailSurah.nomor.toString()
                tvDetailHijaiyah.text = detailSurah.ar
                tvLatin.text = detailSurah.tr
                tvTerjemahan.text = detailSurah.idn
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