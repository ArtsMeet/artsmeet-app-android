package com.artsmeet.app.core.datasource.authentication.impl

import com.artsmeet.app.core.datasource.authentication.LoginDataSource
import com.artsmeet.app.core.datasource.base.BaseDataSource
import com.artsmeet.app.core.repository.authentication.impl.GoogleLoginData
import com.artsmeet.app.core.service.authentication.AuthenticationService
import javax.inject.Inject

class GoogleLoginDataSourceImpl @Inject constructor(
    private val authenticationService: AuthenticationService
):  BaseDataSource(),LoginDataSource<GoogleLoginData> {
    override suspend fun login(data: GoogleLoginData): String = authenticationService.loginWithGoogle(googleLoginData = data)
}