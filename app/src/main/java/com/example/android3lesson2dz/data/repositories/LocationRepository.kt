package com.example.android3lesson2dz.data.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android3lesson2dz.App
import com.example.android3lesson2dz.data.repositories.pagingsources.LocationPagingSources
import com.example.android3lesson2dz.models.LocationModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationRepository {

    fun fetchLocation(): Flow<PagingData<LocationModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                LocationPagingSources(App.locationApiService!!)
            }).flow
    }

    fun fetchDetailLocation(id: Int): MutableLiveData<LocationModel> {
        val data: MutableLiveData<LocationModel> = MutableLiveData()
        App.locationApiService?.fetchDetailLocation(id)
            ?.enqueue(object : Callback<LocationModel> {
                override fun onResponse(
                    call: Call<LocationModel>,
                    response: Response<LocationModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<LocationModel>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}