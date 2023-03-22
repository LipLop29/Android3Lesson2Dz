package com.example.android3lesson2dz.data.repositories.pagingsources

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.android3lesson2dz.data.network.apiserveces.CharacterApiService
import com.example.android3lesson2dz.models.CharacterModel
import okio.IOException
import retrofit2.HttpException

private const val CHARACTER_STARTING_PAGE_INDEX = 1

class CharacterPagingSources(private val characterApiService: CharacterApiService) :
    PagingSource<Int, CharacterModel>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterModel> {
        val position = params.key ?: CHARACTER_STARTING_PAGE_INDEX
        return try {
            val response = characterApiService.fetchCharacters(position)
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

    override fun getRefreshKey(state: PagingState<Int, CharacterModel>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPosition = state.closestPageToPosition(anchorPosition)
            anchorPosition?.prevKey?.plus(1) ?: anchorPosition?.nextKey?.minus(1)
        }
    }
}