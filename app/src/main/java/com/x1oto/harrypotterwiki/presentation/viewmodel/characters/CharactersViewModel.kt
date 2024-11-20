package com.x1oto.harrypotterwiki.presentation.viewmodel.characters

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.x1oto.harrypotterwiki.domain.Repository
import com.x1oto.harrypotterwiki.presentation.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharactersViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var _status = MutableLiveData<Status>()
    val status: LiveData<Status> = _status

    fun fetchCharacters() {
        viewModelScope.launch {
            _status.value = Status.Loading
            try {
                val response = repository.remoteDataSource.getCharacter()
                _status.value = Status.Success(response)
            } catch (e: Exception) {
                _status.value = Status.Error("Something unexpected happened... $e")
            }
        }
    }
}