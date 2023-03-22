package com.example.android3lesson2dz.ui.fragments.episode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.android3lesson2dz.data.repositories.EpisodeRepository
import com.example.android3lesson2dz.models.EpisodeModel

class EpisodeViewModel : ViewModel() {

    private val episodeRepository = EpisodeRepository()

    fun fetchEpisode() = episodeRepository.fetchEpisode().cachedIn(viewModelScope)

    fun fetchDetailEpisode(id: Int): MutableLiveData<EpisodeModel> {
        return episodeRepository.fetchDetailEpisode(id)
    }
}