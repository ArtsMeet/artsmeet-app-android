package com.artsmeet.app.authentication

import com.artsmeet.app.core.androidBaseComponent.BaseViewModel
import com.artsmeet.app.core.repository.authentication.impl.EmailPasswordLoginData
import com.artsmeet.app.core.repository.authentication.impl.GoogleLoginData
import com.artsmeet.app.core.usecase.authentication.LoginUCParams
import com.artsmeet.app.core.usecase.authentication.LoginUseCase
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
                    email,
                    password
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