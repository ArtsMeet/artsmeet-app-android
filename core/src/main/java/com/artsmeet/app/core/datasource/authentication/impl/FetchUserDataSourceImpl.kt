package com.artsmeet.app.core.datasource.authentication.impl

import com.artsmeet.app.core.ArtsMeet
import com.artsmeet.app.core.Constants
import com.artsmeet.app.core.model.authentication.User
import com.artsmeet.app.core.datasource.authentication.FetchUserDataSource
import com.artsmeet.app.core.repository.base.BaseRepository

class FetchUserDataSourceImpl : BaseRepository(), FetchUserDataSource {
    override fun fetchUser(userName: String) {
        ArtsMeet.db.child("${Constants.USER_DB}${userName}")
            .get()
            .addOnSuccessListener {

            }
            .addOnCanceledListener {

            }
    }
}