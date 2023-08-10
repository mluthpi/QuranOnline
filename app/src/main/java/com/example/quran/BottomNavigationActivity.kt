package com.example.quran

import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.quran.databinding.ActivityBottomNavigationBinding
import com.example.quran.ui.home.HomeFragment
import com.example.quran.ui.tafsir.TafsirFragment

class BottomNavigationActivity : AppCompatActivity() {

    private val mOnNavigationOnItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            val fragment : Fragment?
            when (item.itemId) {
                R.id.navigation_surat -> {
                    fragment = HomeFragment()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_dashboard -> {
                    fragment = TafsirFragment()
                    loadFragment(fragment)
                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }

    private var _binding: ActivityBottomNavigationBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        _binding = ActivityBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navView.setOnNavigationItemSelectedListener(mOnNavigationOnItemSelectedListener)

        if (savedInstanceState == null) {
            loadFragment(HomeFragment())
        }
    }

    private fun loadFragment(fragment : Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.main_navigation, fragment)
            .commit()
    }
}