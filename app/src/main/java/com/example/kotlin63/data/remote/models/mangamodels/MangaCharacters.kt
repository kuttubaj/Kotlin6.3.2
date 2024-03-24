package com.example.kotlin63.data.remote.models.mangamodels

import com.google.gson.annotations.SerializedName

data class MangaCharacters(@SerializedName("links")
                           val links: Links)