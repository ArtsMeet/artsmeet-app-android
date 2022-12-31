package com.artsmeet.app.base.repository.authentication.impl

import com.artsmeet.app.base.datasource.authentication.LoginDataSource
import com.artsmeet.app.base.repository.authentication.LoginData
import com.artsmeet.app.base.repository.base.BaseRepository
import com.artsmeet.app.base.repository.authentication.LoginRepository
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