package com.x1oto.harrypotterwiki.data.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters


@Database(
    entities = [CacheCharactersEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(CharactersTypeConverters::class)
abstract class HarryPotterDatabase : RoomDatabase() {
    abstract fun cacheCharactersDao(): CacheCharactersDao
}