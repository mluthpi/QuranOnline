package com.example.quran.presentation.tafsir

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.data.SurahResponseItem
import com.example.quran.data.TafsirResponse
import com.example.quran.databinding.ItemTafsirBinding
import com.example.quran.databinding.ListItemSurahBinding

class TafsirAdapter(val onItemClick: (surahItem: TafsirResponse.Tafsir)-> Unit): RecyclerView.Adapter<TafsirAdapter.SurahHolder>() {

    private val surahList = mutableListOf<TafsirResponse.Tafsir>()

    fun addItems(surahList: List<TafsirResponse.Tafsir>) {
        this.surahList.clear()
        this.surahList.addAll(surahList)
        notifyDataSetChanged()
    }

    class SurahHolder(private val binding: ItemTafsirBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(surah : TafsirResponse.Tafsir) {
            with(binding) {
                tvNumber.text = surah.ayat.toString()
                tvTafsir.text = surah.tafsir
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahHolder {
        val surahBinding = ItemTafsirBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SurahHolder(surahBinding)
    }

    override fun getItemCount(): Int = surahList.size

    override fun onBindViewHolder(holder: SurahHolder, position: Int) {
        val surahItem = surahList[position]
        holder.bind(surahItem)
        holder.itemView.setOnClickListener { onItemClick(surahItem) }
    }


}