package com.example.android3lesson2dz.data.repositories.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android3lesson2dz.data.network.apiserveces.EpisodeApiService
import com.example.android3lesson2dz.models.EpisodeModel
import okio.IOException
import retrofit2.HttpException

private const val EPISODE_STARTING_PAGE_INDEX = 1

class EpisodePagingSources(private val episodeApiService: EpisodeApiService) :
    PagingSource<Int, EpisodeModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, EpisodeModel> {
        val position = params.key ?: EPISODE_STARTING_PAGE_INDEX
        return try {
            val response = episodeApiService.fetchEpisodes(position)
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

    override fun getRefreshKey(state: PagingState<Int, EpisodeModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPosition = state.closestPageToPosition(anchorPosition)
            anchorPosition?.prevKey?.plus(1) ?: anchorPosition?.nextKey?.minus(1)
        }
    }
}