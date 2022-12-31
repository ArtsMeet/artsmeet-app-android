package com.artsmeet.app.authentication.ui

import com.artsmeet.app.authentication.AuthenticationViewModel
import com.artsmeet.app.authentication.databinding.FragmentGetStartedBinding
import com.artsmeet.app.base.androidBaseComponent.BaseFragment

class GetStartedFragment: BaseFragment<FragmentGetStartedBinding,AuthenticationViewModel>(
    FragmentGetStartedBinding::inflate,
    AuthenticationViewModel::class,
    false
) {

    override fun setupViews(binding: FragmentGetStartedBinding, vm: AuthenticationViewModel) {
        binding.materialButton.setOnClickListener {
            vm.loginWithGoogle()
            vm.login("Devanshu","FFF")
        }
    }

}