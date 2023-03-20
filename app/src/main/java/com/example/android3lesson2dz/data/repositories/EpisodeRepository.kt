package com.example.android3lesson2dz.data.repositories

import androidx.lifecycle.MutableLiveData
import com.example.android3lesson2dz.App
import com.example.android3lesson2dz.models.EpisodeModel
import com.example.android3lesson2dz.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeRepository {

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        val data: MutableLiveData<RickAndMortyResponse<EpisodeModel>> = MutableLiveData()
        App.episodeApiService?.fetchEpisodes()
            ?.enqueue(object : Callback<RickAndMortyResponse<EpisodeModel>> {
                override fun onResponse(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    response: Response<RickAndMortyResponse<EpisodeModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<EpisodeModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }

    fun fetchDetailEpisode(id : Int): MutableLiveData<EpisodeModel> {
        val data: MutableLiveData<EpisodeModel> = MutableLiveData()
        App.episodeApiService?.fetchDetailEpisode(id)
            ?.enqueue(object : Callback<EpisodeModel> {
                override fun onResponse(
                    call: Call<EpisodeModel>,
                    response: Response<EpisodeModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<EpisodeModel>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}