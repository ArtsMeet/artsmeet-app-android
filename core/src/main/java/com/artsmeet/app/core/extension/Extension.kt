package com.artsmeet.app.core.extension

import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.artsmeet.app.core.ArtsMeet
import com.artsmeet.app.core.database.base.BaseRoomDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

private val mainScope = CoroutineScope(Dispatchers.Main + Job())

inline fun <VB : ViewDataBinding> AppCompatActivity.viewBinding(
    crossinline bindingInflater: (LayoutInflater) -> VB
) =
    lazy(LazyThreadSafetyMode.NONE) {
        bindingInflater.invoke(layoutInflater)
    }

internal inline fun <reified T : BaseRoomDatabase> buildDatabase(databaseName: String? = null): T {
    return Room.databaseBuilder(
        ArtsMeet.applicationContext,
        T::class.java,
        databaseName ?: "${T::class.simpleName}"
    ).build()
}

fun<T> Flow<T>.collectNonBlocking(
    action: suspend (T) -> Unit
){
    mainScope.launch {
        collectLatest {
            action.invoke(it)
        }
    }
}

fun AppCompatActivity.toast(message:String){
    Toast.makeText(
        this,
        message,
        Toast.LENGTH_SHORT
    ).show()
}
fun Fragment.toast(message:String){
    Toast.makeText(
        this.requireActivity().applicationContext,
        message,
        Toast.LENGTH_SHORT
    ).show()
}

fun AppCompatActivity.toastLong(message: String){
    Toast.makeText(
        this,
        message,
        Toast.LENGTH_LONG
    ).show()
}
fun Fragment.toastLong(message: String){
    Toast.makeText(
        this.requireActivity().applicationContext,
        message,
        Toast.LENGTH_LONG
    ).show()
}

