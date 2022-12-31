package com.artsmeet.app.base.datasource.authentication

import com.artsmeet.app.base.repository.authentication.LoginData

interface LoginDataSource<T:LoginData> {

    fun login(data: T)
}