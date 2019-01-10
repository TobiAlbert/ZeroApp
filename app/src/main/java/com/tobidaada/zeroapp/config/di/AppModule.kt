package com.tobidaada.zeroapp.config.di

import com.tobidaada.zeroapp.koin.KoinHelloRepository
import com.tobidaada.zeroapp.koin.KoinHelloRepositoryImpl
import com.tobidaada.zeroapp.koin.MyScopePresenter
import org.koin.dsl.module.module

val appModule = module {

    // single instance of HelloRepository
    single<KoinHelloRepository> { KoinHelloRepositoryImpl() }

    // Scoped MyScopePresenter instance
    scope("session") { MyScopePresenter(get()) }
}