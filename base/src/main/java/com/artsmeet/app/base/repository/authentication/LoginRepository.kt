package com.artsmeet.app.base.repository.authentication

interface LoginRepository<T:LoginData> {
    fun login(data: T)
}
interface LoginData
