package com.example.kotlin63.data.remote.models.mangamodels

import com.google.gson.annotations.SerializedName

data class Chapters(@SerializedName("links")
                    val links: Links)