package com.x1oto.harrypotterwiki.di

import com.x1oto.harrypotterwiki.data.remote.RemoteDataSourceImpl
import com.x1oto.harrypotterwiki.domain.RemoteDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class BindingModule {
    @Binds
    @Singleton
    abstract fun provideDataSourceImpl(remoteDataSourceImpl: RemoteDataSourceImpl): RemoteDataSource
}