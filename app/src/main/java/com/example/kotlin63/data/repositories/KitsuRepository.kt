package com.example.kotlin63.data.repositories

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.example.kotlin63.data.paging.sourse.AnimePagingSource
import com.example.kotlin63.data.paging.sourse.MangaPagingSource
import com.example.kotlin63.data.remote.apiservice.DetailApiService
import com.example.kotlin63.data.remote.apiservice.KitsuApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class KitsuRepository @Inject constructor(
    private val kitsuApiService: KitsuApiService,
    private val detailKitsuApi: DetailApiService,
) {

    fun fetchManga() = Pager(
        config = PagingConfig(
            pageSize = 20,
            initialLoadSize = 20,
            enablePlaceholders = true
        ),
        pagingSourceFactory = { MangaPagingSource(kitsuApiService) }
    ).flow

    fun fetchAnime() = Pager(
        config = PagingConfig(
            pageSize = 20,
            initialLoadSize = 20,
            enablePlaceholders = true
        ),
        pagingSourceFactory = { AnimePagingSource(kitsuApiService) }
    ).flow

    fun getMangaById(id: Int) = flow {
        emit(detailKitsuApi.getMangaById(id).data)
    }.flowOn(Dispatchers.IO)

    fun getAnimeById(id: Int) = flow {
        emit(detailKitsuApi.getAnimeById(id).data)
    }.flowOn(Dispatchers.IO)
}