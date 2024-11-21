package com.x1oto.harrypotterwiki.domain

import com.x1oto.harrypotterwiki.data.models.character.Characters
import com.x1oto.harrypotterwiki.data.models.spell.Spells

interface RemoteDataSource {
    suspend fun getCharacter(): Characters
    suspend fun getSpells(): Spells
    suspend fun getCharactersByHouse(house: String): Characters
}