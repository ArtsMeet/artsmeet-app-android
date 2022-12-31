package com.artsmeet.app.core.repository.authentication

interface LoginRepository<T:LoginData> {
    fun login(data: T)
}
interface LoginData
