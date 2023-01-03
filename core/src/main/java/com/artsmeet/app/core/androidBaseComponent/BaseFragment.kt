package com.artsmeet.app.core.androidBaseComponent

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import kotlin.reflect.KClass

abstract class BaseFragment<VB : ViewDataBinding, VM : BaseViewModel>(
    private val bindingInflater: (LayoutInflater) -> VB,
    private val vmKClass: KClass<VM>,
    private val isOwnViewModel: Boolean
) : Fragment() {

    private var viewModel:VM? = null
    private var binding:VB?  = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = bindingInflater.invoke(layoutInflater)
        return binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = if (isOwnViewModel)
            ViewModelProvider(this)[vmKClass.java]
        else
            ViewModelProvider(requireActivity())[vmKClass.java]
        setupViews(binding!!)
        setupViews(binding!!,viewModel!!)
        observe(viewModel!!)
        observeForever(viewModel!!)
    }

    /**
     * This function is used for retrieving the binding anywhere in the fragment
     * after it is initialized as non-nullable object
     * @exception ClassCastException In case, it is called before fragment is created
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
     * @param binding binding initialized in the fragment
     */
    open fun setupViews(binding: VB) {}

    /**
     * This function work is also used for initializing the views but
     * it is used in case where the view model is required for initializing the views
     * @param binding binding initialized in the fragment
     * @param vm view model initialized in the fragment
     */
    open fun setupViews(binding: VB, vm: VM) {}

    /**
     * It is used for observing any live data of the view model
     * It is called after the setupView()
     * @see setupViews
     */

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }

    open fun observe(vm:VM) {}

    open fun observeForever(vm: VM){}

    protected fun<T> ActivityResultLauncher<T>.start(
         launchParams: T? = null
    ):Activity?{
        launch(launchParams)
        return this@BaseFragment.requireActivity()
    }
}