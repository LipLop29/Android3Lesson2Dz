package com.example.android3lesson2dz.ui.fragments.character

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.android3lesson2dz.data.repositories.CharacterRepository
import com.example.android3lesson2dz.models.CharacterModel

class CharacterViewModel : ViewModel() {

    private val characterRepository = CharacterRepository()

    fun fetchCharacter() = characterRepository.fetchCharacter().cachedIn(viewModelScope)

    fun fetchDetailCharacters(id: Int): MutableLiveData<CharacterModel> {
        return characterRepository.fetchDetailCharacter(id)
    }
}