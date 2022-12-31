package com.artsmeet.app.base.usecase.base

abstract class BaseUseCaseWithInput<T:BaseUseCaseInputParams> {

    abstract fun process(input: T)
}
