package com.x1oto.harrypotterwiki.presentation.viewmodel.characters

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.x1oto.harrypotterwiki.domain.Repository
import com.x1oto.harrypotterwiki.presentation.utils.CharacterStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var _status = MutableLiveData<CharacterStatus>()
    val status: LiveData<CharacterStatus> = _status

    fun fetchCharacters() {
        viewModelScope.launch {
            _status.value = CharacterStatus.Loading
            try {
                val response = repository.remoteDataSource.getCharacter()
                _status.value = CharacterStatus.Success(response)
            } catch (e: Exception) {
                _status.value = CharacterStatus.Error("Something unexpected happened... $e")
            }
        }
    }

}