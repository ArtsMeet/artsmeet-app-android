package com.artsmeet.app.authentication

import android.util.Log
import com.artsmeet.app.base.Constants
import com.artsmeet.app.base.androidBaseComponent.BaseViewModel
import com.artsmeet.app.base.repository.authentication.impl.EmailPasswordLoginData
import com.artsmeet.app.base.repository.authentication.impl.GoogleLoginData
import com.artsmeet.app.base.usecase.authentication.LoginUCParams
import com.artsmeet.app.base.usecase.authentication.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {


    fun login(
        email:String,
        password:String
    ){
        callWithInput(
            loginUseCase,
            LoginUCParams(
                type = LoginUCParams.LoginType.EMAIL_AND_PASSWORD,
                emailPasswordLoginData = EmailPasswordLoginData(
                    email  + password
                )
            )
        ){

        }
    }

    fun loginWithGoogle(){
        callWithInput(
            loginUseCase,
            LoginUCParams(
                type = LoginUCParams.LoginType.GOOGLE,
                googleLoginData = GoogleLoginData(
                    "GG"
                )
            )
        ){

        }
    }

}