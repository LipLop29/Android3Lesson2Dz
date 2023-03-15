package com.example.android3lesson2dz.data.network

import com.example.android3lesson2dz.data.network.apiserveces.CharacterApiService
import com.example.android3lesson2dz.data.network.apiserveces.EpisodeApiService
import com.example.android3lesson2dz.data.network.apiserveces.LocationApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {

    private var OkHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(30, TimeUnit.SECONDS).readTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS)
        .writeTimeout(30, TimeUnit.SECONDS).build()

    private val retrofitClient = Retrofit.Builder()
        .baseUrl("https://rickandmortyapi.com")
        .addConverterFactory(GsonConverterFactory.create())
        .client(OkHttpClient)
        .build()

    fun provideCharacterApiServices(): CharacterApiService {
        return retrofitClient.create(CharacterApiService::class.java)
    }

    fun provideLocationApiService(): LocationApiService {
        return retrofitClient.create(LocationApiService::class.java)
    }

    fun provideEpisodeApiService(): EpisodeApiService {
        return retrofitClient.create(EpisodeApiService::class.java)
    }
}