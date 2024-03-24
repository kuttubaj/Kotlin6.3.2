package com.example.kotlin63.data.remote.apiservises

import com.example.kotlin63.data.remote.models.animemodels.AnimeResponse
import com.example.kotlin63.data.remote.models.mangamodels.MangaResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val END_POINT_ANIME = "anime/"
private const val END_POINT_MANGA = "manga/"

interface AnimeMangaApiServises {

    @GET(END_POINT_ANIME)
    suspend fun getAnime(
        @Query("offset") offset: Int, @Query("limit") limit: Int
    ): AnimeResponse

    @GET(END_POINT_MANGA)
    suspend fun getManga(
        @Query("offset") offset: Int, @Query("limit") limit: Int
    ): MangaResponse
}