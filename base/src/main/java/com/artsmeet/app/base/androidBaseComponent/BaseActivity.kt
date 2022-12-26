package com.artsmeet.app.base.androidBaseComponent

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass

/**
 * Extend this class to create an activity instead of Android SDK classes
 */
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
    abstract fun setupViews(binding: VB)

    /**
     * This function work is also used for initializing the views but
     * it is used in case where the view model is required for initializing the views
     * @param binding binding initialized in the activity
     * @param vm view model initialized in the activity
     */
    abstract fun setupViews(binding: VB, vm: VM)

    /**
     * It is used for observing any live data of the view model
     * It is called after the setupView()
     * @see setupViews
     */
    open fun observe(vm:VM) {}

    open fun observeForever(vm: VM){}

}