package com.example.android3lesson2dz

import android.app.Application
import com.example.android3lesson2dz.data.network.RetrofitClient
import com.example.android3lesson2dz.data.network.apiserveces.CharacterApiService
import com.example.android3lesson2dz.data.network.apiserveces.EpisodeApiService
import com.example.android3lesson2dz.data.network.apiserveces.LocationApiService

class App : Application() {

    companion object {
        val retrofitClient = RetrofitClient()
        var characterApiServices: CharacterApiService? = null
        var locationApiService: LocationApiService? = null
        var episodeApiService: EpisodeApiService? = null
    }

    override fun onCreate() {
        super.onCreate()
        characterApiServices = retrofitClient.provideCharacterApiServices()
        locationApiService = retrofitClient.provideLocationApiService()
        episodeApiService = retrofitClient.provideEpisodeApiService()
    }
}