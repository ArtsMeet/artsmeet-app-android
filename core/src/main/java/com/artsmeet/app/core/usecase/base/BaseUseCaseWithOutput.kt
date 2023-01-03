package com.artsmeet.app.core.usecase.base

abstract class BaseUseCaseWithOutput<out O:NetworkResponse> {

    abstract fun process():O
}