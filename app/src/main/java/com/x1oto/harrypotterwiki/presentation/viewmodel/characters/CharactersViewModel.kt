package com.x1oto.harrypotterwiki.presentation.viewmodel.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.x1oto.harrypotterwiki.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    fun fetchCharacters() {
        viewModelScope.launch {
            try {
                val result = repository.remoteDataSource.getCharacter()
                // result: [CharacterItem(actor=Daniel Radcliffe, alive=true, alternate_actors=[], alternate_names=[The Boy Who Lived, The Chosen One, Undesirable No. 1, Potty], ancestry=half-blood, dat...
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}