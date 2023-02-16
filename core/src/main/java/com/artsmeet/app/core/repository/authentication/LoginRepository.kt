package com.artsmeet.app.core.repository.authentication

import com.artsmeet.app.core.usecase.authentication.LoginResponse

interface LoginRepository<T:LoginData>{
    suspend fun login(data: T): LoginResponse
}
interface LoginData
