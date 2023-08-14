package com.example.quran.presentation.detail.ui.surat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.data.SurahResponse
import com.example.quran.databinding.ListItemSurahBinding

class SurahAdapter(val onItemClick: (surahItem: SurahResponse)-> Unit): RecyclerView.Adapter<SurahAdapter.SurahHolder>() {



    private val surahList = mutableListOf<SurahResponse>()

    fun addItems(surahList: List<SurahResponse>) {
        this.surahList.clear()
        this.surahList.addAll(surahList)
        notifyDataSetChanged()
    }

    class SurahHolder(private val binding: ListItemSurahBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(surah : SurahResponse) {
            with(binding) {
                tvSurah.text = surah.nama
                tvArti.text = surah.arti
                tvLatin.text = surah.namaLatin
                tvAyat.text = surah.nomor.toString()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahHolder {
        val surahBinding = ListItemSurahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SurahHolder(surahBinding)
    }

    override fun getItemCount(): Int = surahList.size

    override fun onBindViewHolder(holder: SurahHolder, position: Int) {
        val surahItem = surahList[position]
        holder.bind(surahItem)
        holder.itemView.setOnClickListener { onItemClick(surahItem) }
    }


}