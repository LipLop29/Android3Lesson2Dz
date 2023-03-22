package com.example.android3lesson2dz.data.network.apiserveces

import com.example.android3lesson2dz.models.EpisodeModel
import com.example.android3lesson2dz.models.RickAndMortyResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EpisodeApiService {

    @GET("/api/episode")
    suspend fun fetchEpisodes(
        @Query("page") page : Int
    ): RickAndMortyResponse<EpisodeModel>

    @GET("/api/episode/{id}")
    fun fetchDetailEpisode(@Path("id") id : Int): retrofit2.Call<EpisodeModel>
}