package com.example.kotlin63.data.remote.apiservice

import com.example.kotlin63.data.remote.models.DetailResponse
import retrofit2.http.GET
import retrofit2.http.Path

private const val DETAIL_END_POINT_MANGA = "manga/{id}"
private const val DETAIL_END_POINT_ANIME = "anime/{id}"

interface DetailApiService {
    @GET(DETAIL_END_POINT_MANGA)
    suspend fun getAnimeById(
        @Path("id") id: Int
    ): DetailResponse

    @GET(DETAIL_END_POINT_ANIME)
    suspend fun getMangaById(
        @Path("id") id: Int
    ): DetailResponse
}