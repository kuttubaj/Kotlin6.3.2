package com.example.kotlin63.presentation.ui.fragments.detail

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.kotlin63.R
import com.example.kotlin63.databinding.FragmentDetailBinding
import com.example.kotlin63.utils.UiState
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.id?.let { id ->
            viewModel.setId(id)
        }
        subscribeToDetail(view)
        setupListeners()
    }

    private fun subscribeToDetail(view: View) {
        viewModel.detailState.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is UiState.Error -> Log.e("detail", uiState.message, uiState.throwable)
                UiState.Loading -> Snackbar.make(view, uiState.toString(), Snackbar.LENGTH_SHORT)
                    .show()

                is UiState.Success -> {
                    uiState.data.let {data ->
                        data?.let {
                            binding.detaiText.text = it.attributes.description
                            binding.tvDay.text = it.attributes.startDate
                            binding.tvName.text = it.attributes.titles?.en
                            binding.rating.text = it.attributes.ageRating
                            it.attributes.coverImage?.large?.let {coverImage ->
                                Log.e("image", "subscribeToDetail: $coverImage", )
                                Glide.with(binding.fonView).load(coverImage).into(binding.fonView)
                            }
                            Glide.with(binding.artView).load(it.attributes.posterImage.large).into(binding.artView)
                        }
                    }
                }
            }
        }
    }

    private fun setupListeners()  {
        binding.tvBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}