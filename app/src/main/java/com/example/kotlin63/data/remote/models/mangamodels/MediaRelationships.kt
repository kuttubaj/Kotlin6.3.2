package com.example.kotlin63.data.remote.models.mangamodels

import com.google.gson.annotations.SerializedName

data class MediaRelationships(@SerializedName("links")
                              val links: Links)