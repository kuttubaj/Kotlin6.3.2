package com.example.kotlin63.data.remote.models.animemodels

import com.google.gson.annotations.SerializedName

data class CoverImage(
    @SerializedName("large")
    val large: String,
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("original")
    val original: String,
    @SerializedName("small")
    val small: String,
    @SerializedName("tiny")
    val tiny: String
)