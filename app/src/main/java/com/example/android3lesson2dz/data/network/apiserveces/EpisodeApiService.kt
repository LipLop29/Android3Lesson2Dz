package com.example.android3lesson2dz.data.network.apiserveces

import com.example.android3lesson2dz.models.EpisodeModel
import com.example.android3lesson2dz.models.RickAndMortyResponse
import retrofit2.http.GET

interface EpisodeApiService {

    @GET("api/episode")
    fun fetchEpisodes(): retrofit2.Call<RickAndMortyResponse<EpisodeModel>>
}