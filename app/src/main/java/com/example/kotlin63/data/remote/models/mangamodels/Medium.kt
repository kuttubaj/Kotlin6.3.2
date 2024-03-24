package com.example.kotlin63.data.remote.models.mangamodels

import com.google.gson.annotations.SerializedName

data class Medium(@SerializedName("width")
                  val width: Null = null,
                  @SerializedName("height")
                  val height: Null = null)