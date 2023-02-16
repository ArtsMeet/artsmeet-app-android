package com.artsmeet.app.core.datasource.authentication

import com.artsmeet.app.core.repository.authentication.LoginData

interface LoginDataSource<T:LoginData> {
    suspend fun login(data: T):String
}