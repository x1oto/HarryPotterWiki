package com.x1oto.harrypotterwiki.di

import android.content.Context
import androidx.room.Room
import com.x1oto.harrypotterwiki.data.local.room.HarryPotterDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        HarryPotterDatabase::class.java,
        "hp_database"
    ).build()

    @Singleton
    @Provides
    fun provideCacheDao(database: HarryPotterDatabase) = database.cacheCharactersDao()

}