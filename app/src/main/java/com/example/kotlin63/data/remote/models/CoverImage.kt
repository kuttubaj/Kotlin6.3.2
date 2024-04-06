package com.example.kotlin63.data.remote.models

import com.google.gson.annotations.SerializedName

data class CoverImage(
    @SerializedName("large")
    var large: String? = null
)
