package com.artsmeet.app.core.handler

import com.artsmeet.app.core.extension.isLoggedIn
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

class FirebaseAuthHandler {
    suspend fun<T:Any> handle( action: suspend () -> AuthResult):T{
        val result = action()
        return if(result.isLoggedIn()){
            result.user?.uid as T
        } else {
            "" as T
        }
    }
}