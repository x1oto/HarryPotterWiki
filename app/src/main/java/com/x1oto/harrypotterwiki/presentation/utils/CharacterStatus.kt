package com.x1oto.harrypotterwiki.presentation.utils

import com.x1oto.harrypotterwiki.data.models.character.Characters


sealed class CharacterStatus {
    data class Success(val characters: Characters): CharacterStatus()
    data class Error(val error: String): CharacterStatus()
    object Loading: CharacterStatus()
}