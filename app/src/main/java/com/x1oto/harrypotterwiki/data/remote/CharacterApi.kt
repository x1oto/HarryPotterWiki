package com.x1oto.harrypotterwiki.data.remote

import com.x1oto.harrypotterwiki.data.models.Character
import retrofit2.http.GET

interface CharacterApi {
    @GET("characters")
    suspend fun getCharacters(): Character
}