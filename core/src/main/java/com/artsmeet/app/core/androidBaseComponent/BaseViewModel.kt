package com.artsmeet.app.core.androidBaseComponent

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

    protected fun call(useCase:BaseUseCase,onSuccess:() -> Unit){
        ioScope.launch {
            useCase.process()
            onSuccess.invoke() //TODO:Only in case if process is not working on a separate or launching a coroutine
        }
    }

    protected fun <T:BaseUseCaseInputParams> callWithInput(
        useCase: BaseUseCaseWithInput<T>,
        useCaseInputParams: T,
        onSuccess: () -> Unit
    ){
        ioScope.launch {
            useCase.process(useCaseInputParams)
            onSuccess.invoke() //TODO:Only in case if process is not working on a separate or launching a coroutine
        }
    }

    protected fun <T:BaseUseCaseOutput> callWithOutput(
        useCase: BaseUseCaseWithOutput<T>,
        onSuccess: (T) -> Unit
    ){
        ioScope.launch {
            onSuccess.invoke(
                useCase.process()
            )
        }
    }

    protected fun <T:BaseUseCaseInputParams,O:BaseUseCaseOutput> callWithInputOutput(
        useCaseWithInputOutput: BaseUseCaseWithInputOutput<T,O>,
        useCaseInputParams: T,
        onSuccess: (O) -> Unit
    ){
        ioScope.launch {
            onSuccess.invoke(
                useCaseWithInputOutput.process(useCaseInputParams)
            )
        }
    }
}