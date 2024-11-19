package com.x1oto.harrypotterwiki.data.remote

import com.x1oto.harrypotterwiki.data.models.Character
import com.x1oto.harrypotterwiki.domain.RemoteDataSource
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(): RemoteDataSource {

    override suspend fun getCharacters(): Character {
        TODO("Not yet implemented")
    }

}