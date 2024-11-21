package com.x1oto.harrypotterwiki.data.local.room

import com.x1oto.harrypotterwiki.domain.LocalDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val cacheCharactersDao: CacheCharactersDao): LocalDataSource {
    override suspend fun cacheCharacters(charactersEntity: CacheCharactersEntity) {
        cacheCharactersDao.cacheCharacters(charactersEntity)
    }

    override fun fetchCachedCharacters(): Flow<CacheCharactersEntity> {
        return cacheCharactersDao.fetchCachedCharacters()
    }
}