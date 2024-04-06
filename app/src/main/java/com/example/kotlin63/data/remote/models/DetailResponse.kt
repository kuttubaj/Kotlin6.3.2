package com.example.kotlin63.data.remote.models

import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("data")
    val data: Data
)
