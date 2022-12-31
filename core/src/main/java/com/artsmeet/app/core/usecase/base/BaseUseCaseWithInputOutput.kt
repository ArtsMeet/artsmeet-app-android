package com.artsmeet.app.core.usecase.base

abstract class BaseUseCaseWithInputOutput<T:BaseUseCaseInputParams,O:BaseUseCaseOutput> {
    abstract fun process(input: T):O
}