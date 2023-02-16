package com.artsmeet.app.authentication.ui

import android.util.Log
import androidx.activity.result.contract.ActivityResultContracts
import com.artsmeet.app.authentication.AuthenticationViewModel
import com.artsmeet.app.authentication.BuildConfig
import com.artsmeet.app.authentication.databinding.FragmentGetStartedBinding
import com.artsmeet.app.core.Settings
import com.artsmeet.app.core.androidBaseComponent.BaseFragment
import com.artsmeet.app.core.extension.collectNonBlocking
import com.artsmeet.app.core.extension.toast
import com.google.android.gms.auth.api.identity.BeginSignInRequest
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.common.api.Scope

class GetStartedFragment : BaseFragment<FragmentGetStartedBinding, AuthenticationViewModel>(
    FragmentGetStartedBinding::inflate,
    AuthenticationViewModel::class,
    false
) {

    private val googleSignInLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(it.data)
            try {
                val account = task.getResult(ApiException::class.java)
                account.idToken?.let { it1 -> getViewModel().loginWithGoogle(it1) }
            } catch (e: ApiException) {
                Log.e("Google SignIn Failed", e.message, e)
            }
        }
    private var googleSignInClient: GoogleSignInClient? = null

    override fun setupViews(binding: FragmentGetStartedBinding, vm: AuthenticationViewModel) {
        binding.materialButton.setOnClickListener {
            vm.login("test@gmail.com", "test123")
        }
        binding.googleSignInBtn.setOnClickListener {
            val options = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(BuildConfig.GOOGLE_OAUTH_CLIENT_KEY)
                .requestProfile()
                .requestEmail()
                .
                .build()
            googleSignInClient = GoogleSignIn.getClient(this.requireActivity(), options)
            googleSignInLauncher.start(
                googleSignInClient?.signInIntent
            )
        }
    }

    override fun observe(vm: AuthenticationViewModel) {
        Settings.isUserAuthenticated.collectNonBlocking {
            it?.let {
                if(it) toast(
                    "Logged In"
                ) else toast(
                    "Please try again"
                )
            }
        }
    }
}
