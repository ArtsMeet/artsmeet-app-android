package com.artsmeet.app.core.datasource.authentication

import com.artsmeet.app.core.model.authentication.User

interface FetchUserDataSource {

    suspend fun fetchUser(uid: String):User
}