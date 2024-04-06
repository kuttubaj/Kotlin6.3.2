package com.example.kotlin63.presentation.ui.fragments.manga

import androidx.lifecycle.ViewModel
import com.example.kotlin63.data.repositories.KitsuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repositories: KitsuRepository,
) : ViewModel() {

    fun fetchManga() = repositories.fetchManga()
}