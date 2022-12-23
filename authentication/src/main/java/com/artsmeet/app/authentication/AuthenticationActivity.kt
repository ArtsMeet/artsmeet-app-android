package com.artsmeet.app.authentication

import com.artsmeet.app.authentication.databinding.ActivityAuthenticationBinding
import com.artsmeet.app.base.androidBaseComponent.BaseActivity
import com.artsmeet.app.base.androidBaseComponent.BaseViewModel

class AuthenticationActivity : BaseActivity<ActivityAuthenticationBinding,BaseViewModel>(
    ActivityAuthenticationBinding::inflate,
    BaseViewModel::class
) {

    override fun setupViews(binding: ActivityAuthenticationBinding) {

    }

    override fun setupViews(binding: ActivityAuthenticationBinding, vm: BaseViewModel) {

    }

    override fun observe(vm: BaseViewModel) {

    }
}