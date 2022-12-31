package com.artsmeet.app.core.usecase.authentication

import com.artsmeet.app.core.repository.authentication.LoginRepository
import com.artsmeet.app.core.repository.authentication.impl.EmailPasswordLoginData
import com.artsmeet.app.core.repository.authentication.impl.GoogleLoginData
import com.artsmeet.app.core.usecase.base.BaseUseCaseInputParams
import com.artsmeet.app.core.usecase.base.BaseUseCaseWithInput
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val googleRepository: LoginRepository<GoogleLoginData>,
    private val emailPasswordRepository: LoginRepository<EmailPasswordLoginData>,
) : BaseUseCaseWithInput<LoginUCParams>() {
    override fun process(input: LoginUCParams) {
        when (input.type) {
            LoginUCParams.LoginType.GOOGLE -> {
                input.googleLoginData?.let { googleRepository.login(it) }
            }
            LoginUCParams.LoginType.EMAIL_AND_PASSWORD -> {
                input.emailPasswordLoginData?.let { emailPasswordRepository.login(it) }
            }
        }
    }
}

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