package com.example.android3lesson2dz.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3lesson2dz.data.repositories.LocationRepository
import com.example.android3lesson2dz.models.LocationModel
import com.example.android3lesson2dz.models.RickAndMortyResponse

class LocationViewModel : ViewModel() {

    private val locationRepository = LocationRepository()

    fun fetchLocation(): MutableLiveData<RickAndMortyResponse<LocationModel>> {
        return locationRepository.fetchLocation()
    }

    fun fetchDetailLocation(id: Int): MutableLiveData<LocationModel> {
        return locationRepository.fetchDetailLocation(id)
    }
}