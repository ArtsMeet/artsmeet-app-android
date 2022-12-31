package com.artsmeet.app.base.datasource.authentication.provider

import com.artsmeet.app.base.datasource.authentication.LoginDataSource
import com.artsmeet.app.base.datasource.authentication.impl.EmailPasswordLoginDataSourceImpl
import com.artsmeet.app.base.datasource.authentication.impl.GoogleLoginDataSourceImpl
import com.artsmeet.app.base.repository.authentication.impl.EmailPasswordLoginData
import com.artsmeet.app.base.repository.authentication.impl.GoogleLoginData
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class LoginDataSourceProvider {

    @Binds
    abstract fun bindGoogleLoginDataSource(googleLoginDataSourceImpl: GoogleLoginDataSourceImpl):LoginDataSource<GoogleLoginData>

    @Binds
    abstract fun bindEmailPasswordDataSource(emailPasswordLoginDataSourceImpl: EmailPasswordLoginDataSourceImpl):LoginDataSource<EmailPasswordLoginData>
}