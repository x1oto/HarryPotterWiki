package com.x1oto.harrypotterwiki.domain

import com.x1oto.harrypotterwiki.data.local.room.CacheCharactersEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    suspend fun cacheCharacters(charactersEntity: CacheCharactersEntity)
    fun fetchCachedCharacters(): Flow<CacheCharactersEntity>
}