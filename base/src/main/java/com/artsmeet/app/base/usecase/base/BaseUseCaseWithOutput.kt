package com.artsmeet.app.base.usecase.base

abstract class BaseUseCaseWithOutput<O:BaseUseCaseOutput> {

    abstract fun process():O
}