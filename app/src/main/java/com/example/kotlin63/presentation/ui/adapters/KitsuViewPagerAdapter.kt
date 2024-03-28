package com.example.kotlin63.presentation.ui.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlin63.presentation.ui.fragments.AnimeFragment
import com.example.kotlin63.presentation.ui.fragments.MangaFragment

class KitsuViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {
    override fun getItemCount() = 2
    override fun createFragment(position: Int): Fragment {
        return if (position == 1) AnimeFragment() else MangaFragment()
    }
}