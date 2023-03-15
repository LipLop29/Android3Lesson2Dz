package com.example.android3lesson2dz.models

import com.google.gson.annotations.SerializedName

data class EpisodeModel(

    @SerializedName("created")
    val created: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("episode")
    val episode: String,

    @SerializedName("air_date")
    val air_date: String,
)