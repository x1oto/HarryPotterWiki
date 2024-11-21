package com.x1oto.harrypotterwiki.data.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface CacheCharactersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun cacheCharacters(charactersEntity: CacheCharactersEntity)

    @Query("SELECT * FROM cached_characters")
    fun fetchCachedCharacters(): Flow<CacheCharactersEntity>
}