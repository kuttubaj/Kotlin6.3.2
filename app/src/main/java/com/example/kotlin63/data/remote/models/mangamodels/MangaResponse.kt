package com.example.kotlin63.data.remote.models.mangamodels

import com.google.gson.annotations.SerializedName

data class MangaResponse(@SerializedName("data")
                         val data: List<Data>)