package com.artsmeet.app.core.usecase.authentication

import com.artsmeet.app.core.model.authentication.User
import com.artsmeet.app.core.repository.authentication.LoginRepository
import com.artsmeet.app.core.repository.authentication.impl.EmailPasswordLoginData
import com.artsmeet.app.core.repository.authentication.impl.GoogleLoginData
import com.artsmeet.app.core.usecase.base.BaseUseCaseInputParams
import com.artsmeet.app.core.usecase.base.BaseUseCaseWithInputOutput
import com.artsmeet.app.core.usecase.base.NetworkResponse
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val googleRepository: LoginRepository<GoogleLoginData>,
    private val emailPasswordRepository: LoginRepository<EmailPasswordLoginData>,
) : BaseUseCaseWithInputOutput<LoginUCParams, LoginResponse>() {
    override suspend fun process(input: LoginUCParams): LoginResponse {
        return when (input.type) {
            LoginUCParams.LoginType.GOOGLE -> {
                input.googleLoginData?.let {
                    googleRepository.login(it)
                }
            }
            LoginUCParams.LoginType.EMAIL_AND_PASSWORD -> {
                input.emailPasswordLoginData?.let {
                    emailPasswordRepository.login(it)
                }
            }
        }!!
    }
}

data class LoginResponse(
    val user : User? = null
) : NetworkResponse

data class LoginUCParams(
    val type: LoginType,
    val googleLoginData: GoogleLoginData? = null,
    val emailPasswordLoginData: EmailPasswordLoginData? = null
) : BaseUseCaseInputParams {
    enum class LoginType {
        GOOGLE,
        EMAIL_AND_PASSWORD
    }
}