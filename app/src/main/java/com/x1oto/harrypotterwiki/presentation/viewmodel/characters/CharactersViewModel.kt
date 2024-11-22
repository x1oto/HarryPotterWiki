package com.x1oto.harrypotterwiki.presentation.viewmodel.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.x1oto.harrypotterwiki.data.local.room.CacheCharactersDao
import com.x1oto.harrypotterwiki.data.local.room.CacheCharactersEntity
import com.x1oto.harrypotterwiki.data.models.character.Characters
import com.x1oto.harrypotterwiki.domain.Repository
import com.x1oto.harrypotterwiki.presentation.utils.CharacterStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var _status = MutableLiveData<CharacterStatus>()
    val status: LiveData<CharacterStatus> = _status


    fun fetchCharacters() = viewModelScope.launch {
        _status.value = CharacterStatus.Loading
        val localCharacters = fetchLocalCharacters()

        if (!localCharacters.isNullOrEmpty()) {
            _status.value = CharacterStatus.Success(localCharacters)
        } else {
            val remoteCharacters = fetchRemoteCharacters()
            if (remoteCharacters != null) {
                cacheCharacters(remoteCharacters)
                _status.value = CharacterStatus.Success(remoteCharacters)
            } else {
                _status.value =
                    CharacterStatus.Error("We cannot fetch characters at the moment. Try again later or update application.")
            }
        }
    }

    fun teachSpell(id: String) = viewModelScope.launch {
        _status.value = CharacterStatus.Loading
        val localCharacters = fetchLocalCharacters()

        if (localCharacters != null) {
            val updatedCharacters = localCharacters.map { character ->
                if (character.id == id) {
                    character.spellId = listOf("Hello", "It's test")
                }
                character
            }
            val toCharacters = Characters().apply { addAll(updatedCharacters) }
            cacheCharacters(toCharacters)
            _status.value = CharacterStatus.Success(toCharacters)
        }
    }

    private suspend fun fetchLocalCharacters(): Characters? {
        return withContext(Dispatchers.IO) {
            try {
                repository.localDataSource.fetchCachedCharacters().firstOrNull()?.characters
            } catch (e: IllegalArgumentException) {
                _status.value =
                    CharacterStatus.Error("Sorry, we currently cannot fetch cached characters.")
                Log.e("exploreViewModel", e.toString())
                null
            }
        }
    }

    private suspend fun fetchRemoteCharacters(): Characters? {
        return withContext(Dispatchers.Main) {
            try {
                repository.remoteDataSource.getCharacter()
            } catch (e: Exception) {
                _status.value =
                    CharacterStatus.Error("Sorry, we currently cannot fetch characters. Try to check your connection.")
                Log.e("exploreViewModel", e.toString())
                null
            }
        }
    }

    private fun cacheCharacters(characters: Characters) {
        viewModelScope.launch(Dispatchers.IO) {
            Log.d("HHH", "Start caching characters")
            try {
                repository.localDataSource.cacheCharacters(CacheCharactersEntity(0, characters))
                Log.d("HHH", "Caching completed successfully")
            } catch (e: Exception) {
                Log.e("HHH", "Error caching characters", e)
            }
        }
    }

}