package com.example.android3lesson2dz.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3lesson2dz.App
import com.example.android3lesson2dz.models.LocationModel
import com.example.android3lesson2dz.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationViewModel : ViewModel() {

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {

        val data: MutableLiveData<RickAndMortyResponse<LocationModel>> = MutableLiveData()

        App.locationApiService?.fetchLocations()
            ?.enqueue(object : Callback<RickAndMortyResponse<LocationModel>> {

                override fun onResponse(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    response: Response<RickAndMortyResponse<LocationModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<LocationModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}