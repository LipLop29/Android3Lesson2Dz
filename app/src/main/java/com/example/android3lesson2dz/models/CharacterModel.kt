package com.example.android3lesson2dz.models

import com.google.gson.annotations.SerializedName

data class CharacterModel(

    @SerializedName("id")
    val id: Int,

    @SerializedName("gender")
    val gender: String,

    @SerializedName("image")
    val image: String,

    @SerializedName("name")
    val name: String,

    @SerializedName("status")
    val status: String
)
