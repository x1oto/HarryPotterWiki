package com.x1oto.harrypotterwiki.domain

import dagger.hilt.android.scopes.ViewModelScoped

@ViewModelScoped
class Repository(val remoteDataSource: RemoteDataSource)