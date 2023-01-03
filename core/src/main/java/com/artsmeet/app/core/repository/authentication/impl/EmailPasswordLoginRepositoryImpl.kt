package com.artsmeet.app.core.repository.authentication.impl

import com.artsmeet.app.core.ArtsMeet
import com.artsmeet.app.core.Settings
import com.artsmeet.app.core.androidBaseComponent.userDataStore
import com.artsmeet.app.core.datasource.authentication.FetchUserDataSource
import com.artsmeet.app.core.datasource.authentication.LoginDataSource
import com.artsmeet.app.core.model.authentication.User
import com.artsmeet.app.core.repository.authentication.LoginData
import com.artsmeet.app.core.repository.base.BaseRepository
import com.artsmeet.app.core.repository.authentication.LoginRepository
import com.artsmeet.app.core.usecase.authentication.LoginResponse
import kotlinx.coroutines.flow.flow
import javax.inject.Inject
import kotlin.math.log

class EmailPasswordLoginRepositoryImpl @Inject constructor(
    private val loginDataSource: LoginDataSource<EmailPasswordLoginData>,
    private val fetchUserDataSource: FetchUserDataSource
): BaseRepository(), LoginRepository<EmailPasswordLoginData> {

    override suspend fun login(data: EmailPasswordLoginData): LoginResponse {
        val uid = loginDataSource.login(data)
        return if(uid.isNotBlank()){
            val user = fetchUserDataSource.fetchUser(uid)
            LoginResponse(user)
        } else {
            LoginResponse(null)
        }
    }
}

data class EmailPasswordLoginData(
    val email:String,
    val password:String
):LoginData