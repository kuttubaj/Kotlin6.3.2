package com.example.kotlin63.data.paging.sourse

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlin62.ui.model.Data
import com.example.kotlin63.data.remote.apiservice.KitsuApiService
import okio.IOException
import retrofit2.HttpException

class MangaPagingSource(private val animeApi: KitsuApiService) : PagingSource<Int, Data>() {
    override fun getRefreshKey(state: PagingState<Int, Data>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Data> {
        val pageSize = params.loadSize
        val position = params.key ?: 1
        return try {
            val response = animeApi.getManga(limit = pageSize, offset = position)
            val nextPage =
                Uri.parse(response.links.next).getQueryParameter("page[offset]")!!.toInt()
            LoadResult.Page(
                data = response.data, prevKey = null, nextKey = nextPage
            )

        } catch (exception: IOException) {
            LoadResult.Error(exception)
        } catch (exception: HttpException) {
            LoadResult.Error(exception)
        } catch (exception: Exception) {
            LoadResult.Error(exception)
        }
    }
}