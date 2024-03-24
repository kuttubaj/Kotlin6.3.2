package com.example.kotlin63.data.remote.models.animemodels

import com.google.gson.annotations.SerializedName

data class DimensionsX(
    @SerializedName("large")
    val large: Large,
    @SerializedName("medium")
    val medium: Medium,
    @SerializedName("SmallX")
    val small: Small,
    @SerializedName("tiny")
    val tiny: Tiny
)