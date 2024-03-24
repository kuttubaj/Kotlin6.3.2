package com.example.kotlin63.data.remote.models.animemodels

import com.google.gson.annotations.SerializedName

data class StreamingLinks(
    @SerializedName("links")
    val links: LinksX
)