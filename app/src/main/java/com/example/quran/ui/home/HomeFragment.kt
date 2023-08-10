package com.example.quran.ui.home

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.data.SurahResponseItem
import com.example.quran.databinding.FragmentHomeBinding
import com.example.quran.presentation.SurahAdapter
import com.example.quran.presentation.detail.DetailSurahActivity
import com.example.quran.presentation.surah.SurahViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!


    private lateinit var surahViewModel: SurahViewModel

    private val surahAdapter = SurahAdapter {
        val intent = Intent(this@HomeFragment.requireContext(), DetailSurahActivity::class.java)
        intent.putExtra(DetailSurahActivity.KEY_NUMBER, it.nomor)
        startActivity(intent)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        surahViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()
        )[SurahViewModel::class.java]

        surahViewModel.getSurah()

        surahViewModel.listSurah.observe(this, { listSurah ->
            Log.d(TAG,  "${listSurah.size}")
            showSurah(listSurah)
        })


    }

    private fun showSurah(listSurah: List<SurahResponseItem>) {
        surahAdapter.addItems(listSurah)
        binding.rvSurah.apply {
            layoutManager = LinearLayoutManager(
                this@HomeFragment.requireContext(),
                RecyclerView.VERTICAL, false
            )
            adapter = surahAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}