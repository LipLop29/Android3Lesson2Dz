package com.example.android3lesson2dz.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3lesson2dz.App
import com.example.android3lesson2dz.models.CharacterModel
import com.example.android3lesson2dz.models.RickAndMortyResponse
import retrofit2.Call
import retrofit2.Response

class CharacterViewModel : ViewModel() {

    fun fetchCharacter(): MutableLiveData<RickAndMortyResponse<CharacterModel>> {

        val data: MutableLiveData<RickAndMortyResponse<CharacterModel>> = MutableLiveData()

        App.characterApiServices?.fetchCharacters()
            ?.enqueue(object : retrofit2.Callback<RickAndMortyResponse<CharacterModel>> {

                override fun onResponse(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    response: Response<RickAndMortyResponse<CharacterModel>>
                ) {
                    data.value = response.body()
                }

                override fun onFailure(
                    call: Call<RickAndMortyResponse<CharacterModel>>,
                    t: Throwable
                ) {
                    data.value = null
                }
            })
        return data
    }
}