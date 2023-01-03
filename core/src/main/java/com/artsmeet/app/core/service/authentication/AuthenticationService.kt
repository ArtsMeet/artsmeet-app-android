package com.artsmeet.app.core.service.authentication

import com.artsmeet.app.base.BuildConfig
import com.artsmeet.app.core.ArtsMeet
import com.artsmeet.app.core.extension.isLoggedIn
import com.artsmeet.app.core.repository.authentication.impl.EmailPasswordLoginData
import com.artsmeet.app.core.repository.authentication.impl.GoogleLoginData
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthenticationService @Inject constructor(){
    
    suspend fun login(emailPasswordLoginData: EmailPasswordLoginData): String {
        val user =  ArtsMeet.firebaseAuth.signInWithEmailAndPassword(emailPasswordLoginData.email,emailPasswordLoginData.password).await().user
        return user?.uid?:""
    }

    suspend fun loginWithGoogle(googleLoginData: GoogleLoginData):String {
        val credential = GoogleAuthProvider .getCredential(googleLoginData.token,null)
        val user = ArtsMeet.firebaseAuth.signInWithCredential(credential).await().user
        return user?.uid?:""
    }

    suspend fun signOut() = ArtsMeet.firebaseAuth.signOut()
}