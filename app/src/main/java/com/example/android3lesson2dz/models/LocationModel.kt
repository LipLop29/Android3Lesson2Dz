package com.example.android3lesson2dz.models

import com.google.gson.annotations.SerializedName

data class LocationModel(

    @SerializedName("name")
    val name: String,

    @SerializedName("dimension")
    val dimension: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("created")
    val created: String,
)
