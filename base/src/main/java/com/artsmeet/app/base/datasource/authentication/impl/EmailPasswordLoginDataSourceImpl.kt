package com.artsmeet.app.base.datasource.authentication.impl

import com.artsmeet.app.base.ArtsMeet
import com.artsmeet.app.base.datasource.authentication.LoginDataSource
import com.artsmeet.app.base.datasource.base.BaseDataSource
import com.artsmeet.app.base.repository.authentication.impl.EmailPasswordLoginData
import javax.inject.Inject

class EmailPasswordLoginDataSourceImpl @Inject constructor() : BaseDataSource(),
    LoginDataSource<EmailPasswordLoginData> {
    override fun login(data: EmailPasswordLoginData) {
        ArtsMeet.firebaseAuth.signInWithEmailAndPassword(
            data.email,
            data.password
        )
            .addOnSuccessListener {

            }
            .addOnFailureListener {

            }

    }
}