package com.artsmeet.app.base.extension

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

inline  fun <VB:ViewDataBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> VB
) =
    lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(layoutInflater)
    }
