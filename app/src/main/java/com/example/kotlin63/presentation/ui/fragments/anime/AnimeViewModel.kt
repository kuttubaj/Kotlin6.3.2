package com.example.kotlin63.presentation.ui.fragments.anime

import androidx.lifecycle.ViewModel
import com.example.kotlin63.data.repositories.KitsuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel
@Inject constructor(
    private val repositories: KitsuRepository,
) : ViewModel() {
    fun fetchAnime() = repositories.fetchAnime()
}