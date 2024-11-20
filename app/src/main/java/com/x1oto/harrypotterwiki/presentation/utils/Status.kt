package com.x1oto.harrypotterwiki.presentation.utils

import com.x1oto.harrypotterwiki.data.models.Character


sealed class Status {
    data class Success(val character: Character): Status()
    data class Error(val error: String): Status()
    object Loading: Status()
}