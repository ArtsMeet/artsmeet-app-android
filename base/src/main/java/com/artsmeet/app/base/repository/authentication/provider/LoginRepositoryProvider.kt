package com.artsmeet.app.base.repository.authentication.provider

import com.artsmeet.app.base.repository.authentication.LoginRepository
import com.artsmeet.app.base.repository.authentication.impl.EmailPasswordLoginData
import com.artsmeet.app.base.repository.authentication.impl.EmailPasswordLoginRepositoryImpl
import com.artsmeet.app.base.repository.authentication.impl.GoogleLoginData
import com.artsmeet.app.base.repository.authentication.impl.GoogleLoginRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import javax.inject.Qualifier

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