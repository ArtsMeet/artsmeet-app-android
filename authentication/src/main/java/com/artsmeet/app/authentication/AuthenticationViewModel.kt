package com.artsmeet.app.authentication

import androidx.lifecycle.MutableLiveData
import com.artsmeet.app.core.Settings
import com.artsmeet.app.core.androidBaseComponent.BaseViewModel
import com.artsmeet.app.core.repository.authentication.impl.EmailPasswordLoginData
import com.artsmeet.app.core.repository.authentication.impl.GoogleLoginData
import com.artsmeet.app.core.usecase.authentication.LoginUCParams
import com.artsmeet.app.core.usecase.authentication.LoginUseCase
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@HiltViewModel
class AuthenticationViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : BaseViewModel() {

    fun login(
        email:String,
        password:String
    ){

        callWithInputOutput(
            loginUseCase,
            LoginUCParams(
                type = LoginUCParams.LoginType.EMAIL_AND_PASSWORD,
                emailPasswordLoginData = EmailPasswordLoginData(
                    email,
                    password
                )
            )
        ){
            it.let {
                _loading.value = false
                Settings.isUserAuthenticated = flow {
                    emit(true)
                }
            }
        }
    }

    fun loginWithGoogle(token:String){
        callWithInputOutput(
            loginUseCase,
            LoginUCParams(
                type = LoginUCParams.LoginType.GOOGLE,
                googleLoginData = GoogleLoginData(
                    token
                )
            )
        ){
            Settings.isUserAuthenticated = flow {
                emit(true)
            }
        }
    }

}