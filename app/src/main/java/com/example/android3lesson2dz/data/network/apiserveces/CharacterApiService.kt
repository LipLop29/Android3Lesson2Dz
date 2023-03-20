package com.example.android3lesson2dz.data.network.apiserveces

import com.example.android3lesson2dz.models.CharacterModel
import com.example.android3lesson2dz.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface CharacterApiService {

    @GET("/api/character")
    fun fetchCharacters(): retrofit2.Call<RickAndMortyResponse<CharacterModel>>

    @GET("/api/character/{id}")
    fun fetchDetailCharacters(@Path("id") id : Int): retrofit2.Call<CharacterModel>
}