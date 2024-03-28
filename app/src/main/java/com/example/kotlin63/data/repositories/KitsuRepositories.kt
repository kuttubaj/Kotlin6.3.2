package com.example.kotlin63.data.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.kotlin63.data.paging.sourse.AnimePagingSource
import com.example.kotlin62.ui.model.Data
import com.example.kotlin63.data.paging.sourse.MangaPagingSource
import com.example.kotlin63.data.remote.apiservice.KitsuApiService
import javax.inject.Inject

class KitsuRepositories @Inject constructor(
    private val animeApi: KitsuApiService
) {
    fun fetchAnime(): LiveData<PagingData<Data>> {

        return Pager(config = PagingConfig(
            pageSize = 20, initialLoadSize = 20, enablePlaceholders = true
        ), pagingSourceFactory = { AnimePagingSource(animeApi) }).liveData
    }

    fun fetchManga(): LiveData<PagingData<Data>> {
        return Pager(config = PagingConfig(
            pageSize = 20, initialLoadSize = 20, enablePlaceholders = true
        ),

            pagingSourceFactory = { MangaPagingSource(animeApi) }).liveData
    }
}
