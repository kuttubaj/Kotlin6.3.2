package com.example.kotlin63.presentation.ui.fragments.anime

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin63.R
import com.example.kotlin63.databinding.FragmentAnimeBinding
import com.example.kotlin63.presentation.ui.adapters.AnimeAdapter
import com.example.kotlin63.presentation.ui.fragments.ViewPagerFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AnimeFragment : Fragment(R.layout.fragment_anime) {

    private val binding by viewBinding(FragmentAnimeBinding::bind)
    private val viewModel by viewModels<AnimeViewModel>()
    private val animeAdapter = AnimeAdapter(::onItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserver()
        handlePagingState()
    }

    private fun initialize() = with(binding) {
        rvAnime.adapter = animeAdapter
    }

    private fun setupObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchAnime().collect { data ->
                animeAdapter.submitData(data)
            }
        }
    }

    private fun handlePagingState() = with(binding) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                animeAdapter.loadStateFlow.collect {
                    progressBar.isVisible = it.source.refresh is LoadState.Loading
                    appendProgressBar.isVisible = it.source.append is LoadState.Loading
                    // Delete
                    prependProgressBar.isVisible = it.source.prepend is LoadState.Loading
                }
            }
        }
    }

    private fun onItemClick(id: String) {
        findNavController().navigate(
            ViewPagerFragmentDirections.actionViewPagerFragment2ToDetailedKitsuFragment(
                id
            )
        )
    }
}