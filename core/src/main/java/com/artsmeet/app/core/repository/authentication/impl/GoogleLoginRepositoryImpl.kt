package com.artsmeet.app.core.repository.authentication.impl

import com.artsmeet.app.core.datasource.authentication.LoginDataSource
import com.artsmeet.app.core.repository.authentication.LoginData
import com.artsmeet.app.core.repository.base.BaseRepository
import com.artsmeet.app.core.repository.authentication.LoginRepository
import javax.inject.Inject

class GoogleLoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource<GoogleLoginData>
): BaseRepository(), LoginRepository<GoogleLoginData> {
    override fun login(data: GoogleLoginData) {
        loginDataSource.login(data)
    }

}
data class GoogleLoginData(
    val data : String
):LoginData