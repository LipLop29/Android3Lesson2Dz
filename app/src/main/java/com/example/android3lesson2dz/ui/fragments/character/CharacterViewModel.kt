package com.example.android3lesson2dz.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android3lesson2dz.data.repositories.CharacterRepository
import com.example.android3lesson2dz.models.CharacterModel
import com.example.android3lesson2dz.models.RickAndMortyResponse

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()

    fun fetchCharacter(): MutableLiveData<RickAndMortyResponse<CharacterModel>> {
        return characterRepository.fetchCharacter()
    }

    fun fetchDetailCharacters(id: Int): MutableLiveData<CharacterModel> {
        return characterRepository.fetchDetailCharacters(id)
    }
}