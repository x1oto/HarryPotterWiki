package com.x1oto.harrypotterwiki.domain

import dagger.hilt.android.scopes.ViewModelScoped
import javax.inject.Inject

@ViewModelScoped
class Repository @Inject constructor(val remoteDataSource: RemoteDataSource, val localDataSource: LocalDataSource)