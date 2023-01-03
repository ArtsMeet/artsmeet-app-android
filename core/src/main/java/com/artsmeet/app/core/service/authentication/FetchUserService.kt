package com.artsmeet.app.core.service.authentication

import com.artsmeet.app.core.ArtsMeet
import com.artsmeet.app.core.Constants
import com.artsmeet.app.core.model.authentication.User
import com.google.firebase.database.ktx.getValue
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FetchUserService @Inject constructor() {

    suspend fun getUser(uid: String) = ArtsMeet.db.child("${Constants.USER_DB}${uid}")
        .get()
        .await()
        .getValue<User>()!!

}