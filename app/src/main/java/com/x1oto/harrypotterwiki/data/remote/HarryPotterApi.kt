package com.x1oto.harrypotterwiki.data.remote

import com.x1oto.harrypotterwiki.data.models.character.Characters
import com.x1oto.harrypotterwiki.data.models.spell.Spells
import retrofit2.http.GET
import retrofit2.http.Path

interface HarryPotterApi {
    @GET("characters")
    suspend fun getCharacters(): Characters
    @GET("spells")
    suspend fun getSpells(): Spells
    @GET("characters/house/{house}")
    suspend fun getCharactersByHouse(@Path("house") house: String): Characters
}