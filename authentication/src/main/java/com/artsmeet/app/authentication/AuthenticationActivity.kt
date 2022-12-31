package com.artsmeet.app.authentication

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import androidx.navigation.fragment.NavHostFragment
import com.artsmeet.app.authentication.databinding.ActivityAuthenticationBinding
import com.artsmeet.app.core.androidBaseComponent.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthenticationActivity : BaseActivity<ActivityAuthenticationBinding,AuthenticationViewModel>(
    ActivityAuthenticationBinding::inflate,
    AuthenticationViewModel::class
) {
    private val navGraph = R.navigation.navigation_authentication

    override fun setupViews(binding: ActivityAuthenticationBinding) {
        initNavController()
    }

    override fun setupViews(binding: ActivityAuthenticationBinding, vm: AuthenticationViewModel) {

    }

    override fun observe(vm: AuthenticationViewModel) {

    }

    private fun initNavController(){
        val navController = (supportFragmentManager.findFragmentById(R.id.fragment_container)
                as NavHostFragment).navController
        navController.graph = navController.navInflater.inflate(navGraph)
    }

    companion object : ActivityResultContract<Boolean,Boolean>(){
        override fun createIntent(context: Context, input: Boolean): Intent {
            return Intent(context,AuthenticationActivity::class.java)
        }

        override fun parseResult(resultCode: Int, intent: Intent?): Boolean {
            return resultCode == RESULT_OK
        }

    }
}