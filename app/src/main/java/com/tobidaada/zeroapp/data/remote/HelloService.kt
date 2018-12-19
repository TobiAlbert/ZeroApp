package com.tobidaada.zeroapp.data.remote

import com.tobidaada.zeroapp.domain.HelloResponse
import io.reactivex.Single
import retrofit2.http.GET

interface HelloService {

    @GET("hello")
    fun sayHello(): Single<HelloResponse>
}