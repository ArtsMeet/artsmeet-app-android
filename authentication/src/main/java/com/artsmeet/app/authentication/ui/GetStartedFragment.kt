package com.artsmeet.app.authentication.ui

import com.artsmeet.app.authentication.AuthenticationViewModel
import com.artsmeet.app.authentication.databinding.FragmentGetStartedBinding
import com.artsmeet.app.core.Settings
import com.artsmeet.app.core.androidBaseComponent.BaseFragment
import com.artsmeet.app.core.extension.collectNonBlocking
import com.artsmeet.app.core.extension.toast

class GetStartedFragment : BaseFragment<FragmentGetStartedBinding, AuthenticationViewModel>(
    FragmentGetStartedBinding::inflate,
    AuthenticationViewModel::class,
    false
) {

    override fun setupViews(binding: FragmentGetStartedBinding, vm: AuthenticationViewModel) {
        binding.materialButton.setOnClickListener {
            vm.loginWithGoogle()
            vm.login("test@gmail.com", "test123")
        }
    }

    override fun observe(vm: AuthenticationViewModel) {
        Settings.isUserAuthenticated.collectNonBlocking {
            it?.let { value ->
                if (value)
                    toast(
                        "Logged In"
                    )
                else
                    toast(
                        "Please try again"
                    )
            }
        }
    }
}
