package com.larissa.integrativeproject.presentation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.larissa.gistsapp.presentation.FavoriteGistsFragment
import com.larissa.gistsapp.presentation.GistsFragment

class SectionsPagerAdapter (fa: FragmentActivity) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = NUM_PAGES

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> GistsFragment()
            else -> FavoriteGistsFragment()

        }
    }
    companion object {
        private const val NUM_PAGES = 2
    }
}
