package com.artsmeet.app.core.usecase.base

abstract class BaseUseCaseWithInput<T:BaseUseCaseInputParams> {

    abstract fun process(input: T)
}
