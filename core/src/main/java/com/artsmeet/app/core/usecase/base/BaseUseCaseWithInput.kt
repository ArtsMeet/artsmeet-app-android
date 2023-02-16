package com.artsmeet.app.core.usecase.base

abstract class BaseUseCaseWithInput<in I:BaseUseCaseInputParams> {

    abstract suspend fun process(input: I)
}
