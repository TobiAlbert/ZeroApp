package com.tobidaada.zeroapp.domain

import com.tobidaada.zeroapp.data.model.HelloMessage
import com.tobidaada.zeroapp.data.remote.HelloService
import com.tobidaada.zeroapp.utils.mapToDomain
import io.reactivex.Single
import retrofit2.Retrofit

class RestHelloRepository(retrofit: Retrofit): HelloRepository {

    private val helloApi = retrofit.create(HelloService::class.java).sayHello()

    override fun sayHello(): Single<HelloMessage> = helloApi.mapToDomain()

}