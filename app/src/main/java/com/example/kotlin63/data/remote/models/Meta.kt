package com.example.kotlin63.data.remote.models
import com.google.gson.annotations.SerializedName

data class Meta(
    @SerializedName("count")
    val count: Int
)