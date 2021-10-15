package com.larissa.gistsapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayoutMediator
import com.larissa.gistsapp.databinding.ActivityHomeBinding
import com.larissa.integrativeproject.presentation.adapter.SectionsPagerAdapter


class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding

    companion object {
        private const val TAB_1 = "Gists"
        private const val TAB_2 = "Favoritos"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        viewPager.adapter = SectionsPagerAdapter(this)
        viewPager.isUserInputEnabled = false

        val tabLayout = binding.tabLayout

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = when (position) {
                0 -> TAB_1
                else -> TAB_2
            }
        }.attach()
    }
}



