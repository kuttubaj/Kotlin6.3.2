package com.example.kotlin63.data.remote.kitsumodels
import com.example.kotlin62.ui.model.Data
import com.example.kotlin62.ui.model.Links
import com.google.gson.annotations.SerializedName

data class MangaResponse(
    @SerializedName("links")
    val links: Links,
    @SerializedName("data")
    val data: List<Data>
)