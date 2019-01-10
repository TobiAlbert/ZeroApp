package com.tobidaada.zeroapp.koin

class MyScopePresenter(private val repo: KoinHelloRepository) {
    fun sayHello(): String = repo.giveHello()
}