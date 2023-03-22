package com.example.android3lesson2dz.data.network.apiserveces

import com.example.android3lesson2dz.models.CharacterModel
import com.example.android3lesson2dz.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {

    @GET("/api/character")
    suspend fun fetchCharacters(
        @Query("page") page : Int
    ): RickAndMortyResponse<CharacterModel>

    @GET("/api/character/{id}")
    fun fetchDetailCharacters(@Path("id") id : Int): retrofit2.Call<CharacterModel>
}