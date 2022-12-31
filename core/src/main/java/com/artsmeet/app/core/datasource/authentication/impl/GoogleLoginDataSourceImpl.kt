package com.artsmeet.app.core.datasource.authentication.impl

import com.artsmeet.app.core.datasource.authentication.LoginDataSource
import com.artsmeet.app.core.datasource.base.BaseDataSource
import com.artsmeet.app.core.repository.authentication.impl.GoogleLoginData
import javax.inject.Inject

class GoogleLoginDataSourceImpl @Inject constructor():  BaseDataSource(),LoginDataSource<GoogleLoginData> {
    override fun login(data: GoogleLoginData) {

    }

}