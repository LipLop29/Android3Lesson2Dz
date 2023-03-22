package com.example.android3lesson2dz.ui.fragments.location

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.android3lesson2dz.data.repositories.LocationRepository
import com.example.android3lesson2dz.models.LocationModel

class LocationViewModel : ViewModel() {

    private val locationRepository = LocationRepository()

    fun fetchLocation() = locationRepository.fetchLocation().cachedIn(viewModelScope)

    fun fetchDetailLocation(id: Int): MutableLiveData<LocationModel> {
        return locationRepository.fetchDetailLocation(id)
    }
}