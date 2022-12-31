package com.artsmeet.app.authentication.ui

import com.artsmeet.app.authentication.AuthenticationViewModel
import com.artsmeet.app.authentication.databinding.FragmentSignInBinding
import com.artsmeet.app.core.androidBaseComponent.BaseFragment

class SignInFragment: BaseFragment<FragmentSignInBinding,AuthenticationViewModel>(
    FragmentSignInBinding::inflate,
    AuthenticationViewModel::class,
    false
) {
}