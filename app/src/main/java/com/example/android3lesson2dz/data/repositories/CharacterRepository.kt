package com.example.android3lesson2dz.data.repositories

import androidx.lifecycle.MutableLiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.android3lesson2dz.App
import com.example.android3lesson2dz.data.repositories.pagingsources.CharacterPagingSources
import com.example.android3lesson2dz.models.CharacterModel
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterRepository {

    fun fetchCharacter(): Flow<PagingData<CharacterModel>> {
        return Pager(
            config = PagingConfig(
                pageSize = 10,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharacterPagingSources(App.characterApiServices!!)
            }).flow
    }

    fun fetchDetailCharacter(id: Int): MutableLiveData<CharacterModel> {
        val data: MutableLiveData<CharacterModel> = MutableLiveData()
        App.characterApiServices?.fetchDetailCharacters(id)
            ?.enqueue(object : Callback<CharacterModel> {
                override fun onResponse(
                    call: Call<CharacterModel>,
                    response: Response<CharacterModel>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<CharacterModel>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}