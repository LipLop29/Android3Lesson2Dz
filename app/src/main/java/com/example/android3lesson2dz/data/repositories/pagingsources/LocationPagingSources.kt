package com.example.android3lesson2dz.data.repositories.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android3lesson2dz.data.network.apiserveces.LocationApiService
import com.example.android3lesson2dz.models.LocationModel
import okio.IOException
import retrofit2.HttpException

private const val LOCATION_STARTING_PAGE_INDEX = 1

class LocationPagingSources(private val locationApiService: LocationApiService) :
    PagingSource<Int, LocationModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LocationModel> {
        val position = params.key ?: LOCATION_STARTING_PAGE_INDEX
        return try {
            val response = locationApiService.fetchLocations(position)
            val next  = response.info.next
            val nextPageNumber = if (next == null){
                null
            }else
                Uri.parse(response.info.next).getQueryParameter("page")!!.toInt()
            LoadResult.Page(
                response.results,null , nextPageNumber
            )
        }catch (exception : IOException){
            return LoadResult.Error(exception)
        }catch (exception : HttpException){
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, LocationModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPosition = state.closestPageToPosition(anchorPosition)
            anchorPosition?.prevKey?.plus(1) ?: anchorPosition?.nextKey?.minus(1)
        }
    }
}