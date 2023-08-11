package com.example.quran

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.quran.databinding.ActivityBottomNavigationBinding
import com.example.quran.presentation.detail.ui.surat.SuratFragment
import com.example.quran.presentation.detail.ui.notifications.NotificationsFragment
import com.example.quran.presentation.detail.ui.tafsir.TafsirFragment

class BottomNavigationActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val fragment: Fragment?
            when (item.itemId) {
                R.id.navigation_surat -> {
                    fragment = SuratFragment()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    fragment = TafsirFragment()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_notifications -> {
                    fragment = NotificationsFragment()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    private val binding by lazy { ActivityBottomNavigationBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            loadFragment(SuratFragment())
        }

        binding.btnNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    private fun loadFragment(fragment : Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_navigation, fragment)
            .commit()
    }
}