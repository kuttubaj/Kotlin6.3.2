package com.example.kotlin63.presentation.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin63.R
import com.example.kotlin63.databinding.FragmentAnimeBinding
import com.example.kotlin63.presentation.ui.adapters.KitsuAdapter
import com.example.kotlin63.presentation.ui.fragments.viewmodel.AnimeViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.fragment_anime) {

    private val binding by viewBinding(FragmentAnimeBinding::bind)
    private val viewModel by viewModels<AnimeViewModel>()
    private val animeAdapter = KitsuAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserver()

        viewLifecycleOwner.lifecycleScope.launch {
            delay(2000)
            if (binding.progressBar.isVisible) {
                binding.progressBar.isVisible = false
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                animeAdapter.loadStateFlow.collect {
                    binding.appendProgressBar.isVisible = it.source.prepend is LoadState.Loading
                    binding.prependProgressBar.isVisible = it.source.append is LoadState.Loading
                }
            }
        }
    }

    private fun initialize() = with(binding) {
        rvAnime.apply {
            adapter = animeAdapter
        }
    }

    private fun setupObserver() {
        viewModel.fetchAnime().observe(viewLifecycleOwner) {
            viewLifecycleOwner.lifecycleScope.launch {
                animeAdapter.submitData(it)
            }
        }
    }
}