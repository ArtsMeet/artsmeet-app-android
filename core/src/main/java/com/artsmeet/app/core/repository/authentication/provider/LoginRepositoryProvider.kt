package com.artsmeet.app.core.repository.authentication.provider

import com.artsmeet.app.core.repository.authentication.LoginRepository
import com.artsmeet.app.core.repository.authentication.impl.EmailPasswordLoginData
import com.artsmeet.app.core.repository.authentication.impl.EmailPasswordLoginRepositoryImpl
import com.artsmeet.app.core.repository.authentication.impl.GoogleLoginData
import com.artsmeet.app.core.repository.authentication.impl.GoogleLoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class LoginRepositoryProvider {

    @Binds
    abstract fun bindGoogleLoginRepository(
        googleLoginRepositoryImpl: GoogleLoginRepositoryImpl
    ): LoginRepository<GoogleLoginData>

    @Binds
    abstract fun bindEmailPasswordLoginRepository(
        emailPasswordLoginRepositoryImpl: EmailPasswordLoginRepositoryImpl
    ): LoginRepository<EmailPasswordLoginData>
}