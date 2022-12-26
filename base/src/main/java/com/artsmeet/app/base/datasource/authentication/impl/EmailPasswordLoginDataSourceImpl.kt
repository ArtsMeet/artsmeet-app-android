package com.artsmeet.app.base.datasource.authentication.impl

import android.util.Log
import com.artsmeet.app.base.Constants
import com.artsmeet.app.base.datasource.authentication.LoginDataSource
import com.artsmeet.app.base.datasource.base.BaseDataSource
import com.artsmeet.app.base.repository.authentication.impl.EmailPasswordLoginData
import javax.inject.Inject

class EmailPasswordLoginDataSourceImpl @Inject constructor():BaseDataSource(), LoginDataSource<EmailPasswordLoginData> {
    override fun login(data: EmailPasswordLoginData) {

    }
}