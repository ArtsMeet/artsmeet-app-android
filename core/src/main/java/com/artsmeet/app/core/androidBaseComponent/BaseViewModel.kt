package com.artsmeet.app.core.androidBaseComponent

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.artsmeet.app.core.usecase.base.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
open class BaseViewModel @Inject constructor(): ViewModel() {

    private val ioScope = CoroutineScope(Dispatchers.IO + Job())
    protected val _loading = MutableLiveData(false)
    val loading:LiveData<Boolean> = _loading

    protected fun call(useCase:BaseUseCase,onSuccess:() -> Unit){
        ioScope.launch {
            useCase.process()
            onSuccess.invoke() //TODO:Only in case if process is not working on a separate or launching a coroutine
        }
    }

    protected fun <I:BaseUseCaseInputParams> callWithInput(
        useCase: BaseUseCaseWithInput<I>,
        useCaseInputParams: I,
        onSuccess: () -> Unit
    ){
        ioScope.launch {
            useCase.process(useCaseInputParams)
            onSuccess.invoke() //TODO:Only in case if process is not working on a separate or launching a coroutine
        }
    }

    protected fun <O:NetworkResponse> callWithOutput(
        useCase: BaseUseCaseWithOutput<O>,
        onSuccess: (O) -> Unit
    ){
        ioScope.launch {
            onSuccess.invoke(
                useCase.process()
            )
        }
    }

    protected fun <I:BaseUseCaseInputParams,O:NetworkResponse> callWithInputOutput(
        useCaseWithInputOutput: BaseUseCaseWithInputOutput<I,O>,
        useCaseInputParams: I,
        onSuccess: (O) -> Unit
    ){
        ioScope.launch {
            onSuccess.invoke(
                useCaseWithInputOutput.process(useCaseInputParams)
            )
        }
    }
}