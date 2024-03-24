package com.example.kotlin63.data.remote.models.animemodels

import com.google.gson.annotations.SerializedName

data class Medium(
    @SerializedName("height")
    val height: Any,
    @SerializedName("width")
    val width: Any
)