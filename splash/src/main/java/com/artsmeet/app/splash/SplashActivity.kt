package com.artsmeet.app.splash

import android.annotation.SuppressLint
import com.artsmeet.app.authentication.AuthenticationActivity
import com.artsmeet.app.core.Settings
import com.artsmeet.app.core.androidBaseComponent.BaseActivity
import com.artsmeet.app.core.extension.collectNonBlocking
import com.artsmeet.app.splash.databinding.ActivitySplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding,SplashViewModel>(
    ActivitySplashBinding::inflate,
    SplashViewModel::class
) {

    private val authenticationActivity = registerForActivityResult(AuthenticationActivity){}

    override fun observe(vm: SplashViewModel) {
        Settings.isUserAuthenticated.collectNonBlocking {
            if(it != null) {
                if (!it)
                    authenticationActivity.start().finish()
            } else
                authenticationActivity.start().finish()
        }
    }
}