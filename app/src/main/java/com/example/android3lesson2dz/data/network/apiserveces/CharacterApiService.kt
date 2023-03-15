package com.example.android3lesson2dz.data.network.apiserveces

import com.example.android3lesson2dz.models.CharacterModel
import com.example.android3lesson2dz.models.RickAndMortyResponse
import retrofit2.http.GET

interface CharacterApiService {

    @GET("/api/character")
    fun fetchCharacters(): retrofit2.Call<RickAndMortyResponse<CharacterModel>>
}