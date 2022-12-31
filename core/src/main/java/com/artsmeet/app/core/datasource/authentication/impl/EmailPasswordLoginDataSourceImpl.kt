package com.artsmeet.app.core.datasource.authentication.impl

import com.artsmeet.app.core.ArtsMeet
import com.artsmeet.app.core.Settings
import com.artsmeet.app.core.datasource.authentication.LoginDataSource
import com.artsmeet.app.core.datasource.base.BaseDataSource
import com.artsmeet.app.core.repository.authentication.impl.EmailPasswordLoginData
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class EmailPasswordLoginDataSourceImpl @Inject constructor() : BaseDataSource(),
    LoginDataSource<EmailPasswordLoginData> {
    override fun login(data: EmailPasswordLoginData) {
        ArtsMeet.firebaseAuth.signInWithEmailAndPassword(
            data.email,
            data.password
        )
            .addOnSuccessListener {
                Settings.isUserAuthenticated = flow {
                    emit(true)
                }
            }
            .addOnFailureListener {

            }

    }
}