package com.example.kotlin63.presentation.ui.fragments.manga

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin63.R
import com.example.kotlin63.databinding.FragmentMangaBinding
import com.example.kotlin63.presentation.ui.adapters.MangaAdapter
import com.example.kotlin63.presentation.ui.fragments.ViewPagerFragmentDirections
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : Fragment(R.layout.fragment_manga) {

    private val binding by viewBinding(FragmentMangaBinding::bind)
    private val viewModel by viewModels<MangaViewModel>()
    private val mangaAdapter = MangaAdapter(::onItemClick)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupObserver()
        handlePagingState()
    }

    private fun initialize() = with(binding) {
        rvManga.adapter = mangaAdapter
    }

    private fun setupObserver() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.fetchManga().collect { data ->
                mangaAdapter.submitData(data)
            }
        }
    }


    private fun handlePagingState() = with(binding) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(androidx.lifecycle.Lifecycle.State.STARTED) {
                mangaAdapter.loadStateFlow.collect {
                    progressBar.isVisible = it.source.refresh is LoadState.Loading
                    appendProgress.isVisible = it.source.append is LoadState.Loading
                    // Delete
                    prependProgress.isVisible = it.source.prepend is LoadState.Loading
                }
            }
        }
    }

    private fun onItemClick(id:String){
        findNavController().navigate(ViewPagerFragmentDirections.actionViewPagerFragment2ToDetailedKitsuFragment(id))
    }
}