package com.example.android3lesson2dz.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3lesson2dz.App
import com.example.android3lesson2dz.models.EpisodeModel
import com.example.android3lesson2dz.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeViewModel : ViewModel() {

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
}