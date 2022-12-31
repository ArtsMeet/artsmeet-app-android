package com.artsmeet.app.core.datasource.authentication

import com.artsmeet.app.core.model.authentication.User

interface FetchUserDataSource {

    fun fetchUser(userName: String)
}