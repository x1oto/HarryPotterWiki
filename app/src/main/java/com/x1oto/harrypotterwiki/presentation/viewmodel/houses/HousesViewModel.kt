package com.x1oto.harrypotterwiki.presentation.viewmodel.houses

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.x1oto.harrypotterwiki.data.models.character.Characters
import com.x1oto.harrypotterwiki.domain.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HousesViewModel @Inject constructor(private val repository: Repository) : ViewModel() {

    private var _status = MutableLiveData<Characters>()
    val status: LiveData<Characters> = _status

    fun getCharactersByHouse(house: String) {
        viewModelScope.launch {
            try {
                val response = repository.remoteDataSource.getCharactersByHouse(house)
                Log.d("HHH", response.toString())
                _status.value = response
            } catch (e: Exception) {

            }
        }
    }
}