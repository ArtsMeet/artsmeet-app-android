package com.artsmeet.app.base.datasource.authentication.impl

import android.util.Log
import com.artsmeet.app.base.Constants
import com.artsmeet.app.base.datasource.authentication.LoginDataSource
import com.artsmeet.app.base.datasource.base.BaseDataSource
import com.artsmeet.app.base.repository.authentication.impl.GoogleLoginData
import javax.inject.Inject

class GoogleLoginDataSourceImpl @Inject constructor():  BaseDataSource(),LoginDataSource<GoogleLoginData> {
    override fun login(data: GoogleLoginData) {

    }

}