package com.x1oto.harrypotterwiki.presentation.utils

import com.x1oto.harrypotterwiki.data.models.character.Characters
import com.x1oto.harrypotterwiki.data.models.spell.Spells

sealed class SpellStatus {
    data class Success(val spells: Spells): SpellStatus()
    data class Error(val error: String): SpellStatus()
    object Loading: SpellStatus()
}