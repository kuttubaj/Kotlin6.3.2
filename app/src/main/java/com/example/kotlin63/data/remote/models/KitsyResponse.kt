package com.example.kotlin63.data.remote.models
import com.google.gson.annotations.SerializedName

data class KitsyResponse(
    @SerializedName("links")
    val links: Links,
    @SerializedName("data")
    val data: List<Data>
)