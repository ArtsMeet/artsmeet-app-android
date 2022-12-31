package com.artsmeet.app.core.androidBaseComponent

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.ViewModelProvider
import com.artsmeet.app.core.Constants
import kotlin.reflect.KClass

/**
 * Extend this class to create an activity instead of Android SDK classes
 */

val Context.dataStore by preferencesDataStore(
    name = Constants.PREFERENCES_NAME
)

abstract class BaseActivity<VB: ViewDataBinding, VM:BaseViewModel>(
    private val bindingInflater: (LayoutInflater) -> VB,
    private val vmKClass: KClass<VM>
) : AppCompatActivity() {

    private var binding: VB? = null

    private var viewModel:VM? = null

    companion object{
        private const val ON_CREATE = "ON_CREATE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(javaClass.simpleName, ON_CREATE)
        viewModel = ViewModelProvider(this)[vmKClass.java]
        binding = bindingInflater.invoke(layoutInflater)
        setContentView(binding!!.root)
        setupViews(binding!!)
        setupViews(binding!!, viewModel!!)
        observe(viewModel!!)
        observeForever(viewModel!!)
    }

    /**
     * This function is used for retrieving the binding anywhere in the activity
     * after it is initialized as non-nullable object
     * @exception ClassCastException In case, it is called before activity is created
     */
    fun getBinding() = binding as VB

    /**
     * This function is used for retrieving the viewModel anywhere in the fragment
     * after it is initialized as non-nullable object
     * @exception ClassCastException In case, it is called before fragment is created
     */
    fun getViewModel() = viewModel as VM

    /**
     * This is function is used for initializing the views
     * or doing any view related work
     * @param binding binding initialized in the activity
     */
    open fun setupViews(binding: VB) {}

    /**
     * This function work is also used for initializing the views but
     * it is used in case where the view model is required for initializing the views
     * @param binding binding initialized in the activity
     * @param vm view model initialized in the activity
     */
    open fun setupViews(binding: VB, vm: VM) {}

    /**
     * It is used for observing any live data of the view model
     * It is called after the setupView()
     * @see setupViews
     */
    open fun observe(vm:VM) {}

    open fun observeForever(vm: VM){}

    fun<T:Any> ActivityResultLauncher<T>.start(
        launchParams:T? = null
    ):AppCompatActivity {
        launch(launchParams)
        return this@BaseActivity
    }

    /**
     * Use this as base class for any data class passed as parameter
     * to ensure type safety
     */
    abstract class LaunchParams
}