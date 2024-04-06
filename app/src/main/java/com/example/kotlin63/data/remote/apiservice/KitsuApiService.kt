package com.example.kotlin63.data.remote.apiservice

import com.example.kotlin63.data.remote.models.KitsyResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val END_POINT_ANIME = "anime"
private const val END_POINT_MANGA = "manga"

interface KitsuApiService {

    @GET(END_POINT_ANIME)
    suspend fun getAnime(
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") limit: Int
    ): KitsyResponse

    @GET(END_POINT_MANGA)
    suspend fun getManga(
        @Query("page[offset]") offset: Int,
        @Query("page[limit]") limit: Int
    ): KitsyResponse
}