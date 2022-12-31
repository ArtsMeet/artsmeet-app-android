package com.artsmeet.app.core.usecase.base

abstract class BaseUseCaseWithOutput<O:BaseUseCaseOutput> {

    abstract fun process():O
}