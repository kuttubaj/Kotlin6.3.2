package com.example.kotlin63.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.android4_2.data.paging.source.AnimePagingSource
import com.example.kotlin63.data.paging.sourse.MangaPagingSource
import com.example.kotlin63.data.remote.apiservises.AnimeMangaApiServises
import com.example.kotlin63.data.remote.models.animemodels.Data
import javax.inject.Inject

class AnimeMangaRepositories @Inject constructor(
    private val animeApi: AnimeMangaApiServises
) {
    fun fetchAnime(): LiveData<PagingData<Data>> {

        return Pager(config = PagingConfig(
            pageSize = 20, initialLoadSize = 20, enablePlaceholders = true
        ), pagingSourceFactory = { AnimePagingSource(animeApi) }).liveData
    }

    fun fetchManga(): LiveData<PagingData<com.example.kotlin63.data.remote.models.mangamodels.Data>> {
        return Pager(config = PagingConfig(
            pageSize = 20, initialLoadSize = 20, enablePlaceholders = true
        ),

            pagingSourceFactory = { MangaPagingSource(animeApi) }).liveData
    }
}
