package com.artsmeet.app.core.datasource.authentication.impl

import com.artsmeet.app.core.datasource.authentication.LoginDataSource
import com.artsmeet.app.core.datasource.base.BaseDataSource
import com.artsmeet.app.core.repository.authentication.impl.EmailPasswordLoginData
import com.artsmeet.app.core.service.authentication.AuthenticationService
import javax.inject.Inject

class EmailPasswordLoginDataSourceImpl @Inject constructor(
    private val authenticationService: AuthenticationService
) : BaseDataSource(),
    LoginDataSource<EmailPasswordLoginData> {
    override suspend fun login(data: EmailPasswordLoginData): String = authenticationService.login(data)
}