package com.example.kotlin63.presentation.ui.fragments.viewmodel

import androidx.lifecycle.ViewModel
import com.example.kotlin63.data.repositories.KitsuRepositories
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repositories: KitsuRepositories
) : ViewModel() {

    fun fetchManga() = repositories.fetchManga()
}