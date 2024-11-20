package com.x1oto.harrypotterwiki.presentation.viewmodel.spells

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.x1oto.harrypotterwiki.domain.Repository
import com.x1oto.harrypotterwiki.presentation.utils.SpellStatus
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SpellsViewModel @Inject constructor(private val repository: Repository): ViewModel() {

    private var _status = MutableLiveData<SpellStatus>()
    val status: LiveData<SpellStatus> = _status

    fun fetchSpells() {
        viewModelScope.launch {
            _status.value = SpellStatus.Loading
            try {
                val response = repository.remoteDataSource.getSpells()
                _status.value = SpellStatus.Success(response)
            } catch (e: Exception) {
                _status.value = SpellStatus.Error("Cannot fetch spells at the moment. $e")
            }
        }
    }

}