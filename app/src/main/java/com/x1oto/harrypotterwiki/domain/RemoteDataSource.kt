package com.x1oto.harrypotterwiki.domain

import com.x1oto.harrypotterwiki.data.models.Character

interface RemoteDataSource {
    suspend fun getCharacters(): Character
}