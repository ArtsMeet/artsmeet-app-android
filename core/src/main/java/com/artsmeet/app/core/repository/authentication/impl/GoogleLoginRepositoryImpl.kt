package com.artsmeet.app.core.repository.authentication.impl

import com.artsmeet.app.core.datasource.authentication.FetchUserDataSource
import com.artsmeet.app.core.datasource.authentication.LoginDataSource
import com.artsmeet.app.core.repository.authentication.LoginData
import com.artsmeet.app.core.repository.authentication.LoginRepository
import com.artsmeet.app.core.repository.base.BaseRepository
import com.artsmeet.app.core.usecase.authentication.LoginResponse
import javax.inject.Inject

class GoogleLoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource<GoogleLoginData>,
    private val fetchUserDataSource: FetchUserDataSource
): BaseRepository(), LoginRepository<GoogleLoginData> {
    override suspend fun login(data: GoogleLoginData): LoginResponse {
        val uid = loginDataSource.login(data)
        if(uid.isNotBlank()){
            return LoginResponse(fetchUserDataSource.fetchUser(uid))
        }
        return LoginResponse(null)
    }

}
data class GoogleLoginData(
    val token : String
):LoginData