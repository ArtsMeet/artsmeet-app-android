package com.artsmeet.app.base.repository.authentication.impl

import com.artsmeet.app.base.datasource.authentication.LoginDataSource
import com.artsmeet.app.base.repository.authentication.LoginData
import com.artsmeet.app.base.repository.base.BaseRepository
import com.artsmeet.app.base.repository.authentication.LoginRepository
import javax.inject.Inject

class EmailPasswordLoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource<EmailPasswordLoginData>
): BaseRepository(), LoginRepository<EmailPasswordLoginData> {
    override fun login(data: EmailPasswordLoginData) {
        loginDataSource.login(data)
    }
}

data class EmailPasswordLoginData(
    val email:String,
    val password:String
):LoginData