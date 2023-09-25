package com.example.quran.presentation.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.databinding.ListItemSurahBinding
import com.example.quran.model.QuranEntity

class FavoriteAdapter(val onItemClick : (surahItem: QuranEntity)-> Unit) : RecyclerView.Adapter<FavoriteAdapter.SurahHolder>() {

    private val surahList = mutableListOf<QuranEntity>()

    fun addItems(surahList: List<QuranEntity>) {
        this.surahList.clear()
        this.surahList.add(surahList)
        notifyDataSetChanged()
    }

    class SurahHolder(private val binding: ListItemSurahBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(surah: QuranEntity) {
            with(binding) {
                tvSurah.text = surah.nama
                tvArti.text = surah.arti
                tvLatin.text = surah.namaLatin
                tvAyat.text = surah.nomor.toString()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SurahHolder {
        val surahBinding = ListItemSurahBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return SurahHolder(surahBinding)
    }

    override fun getItemCount(): Int = surahList.size

    override fun onBindViewHolder(holder: SurahHolder, position: Int) {
        val surahItem = surahList[position]
        holder.bind(surahItem)
        holder.itemView.setOnClickListener{onItemClick(surahItem)}
    }
}