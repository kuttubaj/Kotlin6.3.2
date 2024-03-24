package com.example.kotlin63.data.remote.models.animemodels

import com.google.gson.annotations.SerializedName

data class AnimeCharacters(
    @SerializedName("links")
    val links: LinksX
)