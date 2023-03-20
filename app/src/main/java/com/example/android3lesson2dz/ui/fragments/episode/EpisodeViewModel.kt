package com.example.android3lesson2dz.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3lesson2dz.data.repositories.EpisodeRepository
import com.example.android3lesson2dz.models.EpisodeModel
import com.example.android3lesson2dz.models.RickAndMortyResponse

class EpisodeViewModel : ViewModel() {

    private val episodeRepository = EpisodeRepository()

    fun fetchEpisode(): MutableLiveData<RickAndMortyResponse<EpisodeModel>> {
        return episodeRepository.fetchEpisode()
    }

    fun fetchDetailEpisode(id: Int): MutableLiveData<EpisodeModel> {
        return episodeRepository.fetchDetailEpisode(id)
    }
}