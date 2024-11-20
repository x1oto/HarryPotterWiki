package com.x1oto.harrypotterwiki.data.remote

import com.x1oto.harrypotterwiki.data.models.character.Characters
import com.x1oto.harrypotterwiki.data.models.spell.Spells
import com.x1oto.harrypotterwiki.domain.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(
    private val harryPotterApi: HarryPotterApi
): RemoteDataSource {

    override suspend fun getCharacter(): Characters {
        return harryPotterApi.getCharacters()
    }

    override suspend fun getSpells(): Spells {
        return harryPotterApi.getSpells()
    }

}