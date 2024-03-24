package com.example.kotlin63.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin63.R
import com.example.kotlin63.databinding.FragmentViewPagerBinding
import com.example.kotlin63.presentation.ui.adapters.AnimeMangaViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    private val binding by viewBinding(FragmentViewPagerBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    private fun initialize() {
        binding.viewPager.adapter = AnimeMangaViewPagerAdapter(this)

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            when (position) {
                0 -> {
                    tab.text = "Manga"
                }

                1 -> {
                    tab.text = "Anime"
                }
            }
        }.attach()
    }
}