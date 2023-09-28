package com.example.quran.presentation.surat

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quran.data.SurahResponseItem
import com.example.quran.databinding.FragmentSuratBinding

class  SuratFragment : Fragment() {

    private var _binding: FragmentSuratBinding? = null
    private val binding get() = _binding!!


    private lateinit var surahViewModel: SurahViewModel

    private val surahAdapter = SurahAdapter {
        val intent = Intent(this@SuratFragment.requireContext(), DetailSurahActivity::class.java)
        intent.putExtra(DetailSurahActivity.KEY_NUMBER, it.nomor)
        println("DATA NOMER: ${it.nomor}")
        startActivity(intent)
    }



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSuratBinding.inflate(inflater, container, false)
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        surahViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()
        )[SurahViewModel::class.java]

        surahViewModel.getSurah()

        surahViewModel.listSurah.observe(this, { listSurah ->
            showSurah(listSurah)
        })


    }

    private fun showSurah(listSurah: List<SurahResponseItem>) {
        surahAdapter.addItems(listSurah)
        binding.rvSurah.apply {
            layoutManager = LinearLayoutManager(
                this@SuratFragment.requireContext(),
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