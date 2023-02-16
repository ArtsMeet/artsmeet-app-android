package com.artsmeet.app.core.usecase.base

abstract class BaseUseCaseWithInputOutput<in I:BaseUseCaseInputParams,out O:NetworkResponse?> {
    abstract suspend fun process(input: I):O
}