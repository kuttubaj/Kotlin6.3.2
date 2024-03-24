package com.example.kotlin63.data.remote.models.animemodels

import com.google.gson.annotations.SerializedName

data class PosterImage(
    @SerializedName("large")
    val large: String,
    @SerializedName("medium")
    val medium: String,
    @SerializedName("meta")
    val meta: MetaX,
    @SerializedName("original")
    val original: String,
    @SerializedName("small")
    val small: String,
    @SerializedName("tiny")
    val tiny: String
)