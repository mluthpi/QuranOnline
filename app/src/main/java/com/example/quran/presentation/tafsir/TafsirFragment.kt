package com.example.quran.presentation.tafsir

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
import com.example.quran.databinding.FragmentTafsirBinding
import com.example.quran.presentation.surat.SurahAdapter
import com.example.quran.presentation.surat.SurahViewModel

class TafsirFragment : Fragment() {

    private var _binding: FragmentTafsirBinding? = null
    private val binding get() = _binding!!

    private lateinit var surahViewModel: SurahViewModel

    private val tafsirAdapter = SurahAdapter {
        val intent = Intent(this@TafsirFragment.requireContext(), TafsirDetailActivity::class.java)
        intent.putExtra(TafsirDetailActivity.KEY_NUMBER, it.nomor)
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentTafsirBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        surahViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()
        )[SurahViewModel::class.java]

        surahViewModel.getSurah()

        surahViewModel.listSurah.observe(this, { listSurah ->
            showTafsir(listSurah)
        })

        surahViewModel.isLoading.observe(this) { isLoading ->
            setupLoading(isLoading)
        }
    }

    private fun showTafsir(listSurah: List<SurahResponseItem>) {
        tafsirAdapter.addItems(listSurah)
        binding.rvSurah.apply {
            layoutManager = LinearLayoutManager(
                this@TafsirFragment.requireContext(),
                RecyclerView.VERTICAL, false
            )
            adapter = tafsirAdapter
        }
    }

    private fun setupLoading(isLoading: Boolean) {
        with(binding) {
            if (isLoading) {
                progressbar.visibility = View.VISIBLE
            } else {
                progressbar.visibility = View.GONE
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}