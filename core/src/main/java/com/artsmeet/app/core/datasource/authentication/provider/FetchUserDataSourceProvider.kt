package com.artsmeet.app.core.datasource.authentication.provider

import com.artsmeet.app.core.datasource.authentication.FetchUserDataSource
import com.artsmeet.app.core.datasource.authentication.impl.FetchUserDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class FetchUserDataSourceProvider {

    @Binds
    abstract fun bindFetchUserDataSource(fetchUserDataSourceImpl: FetchUserDataSourceImpl):FetchUserDataSource
}