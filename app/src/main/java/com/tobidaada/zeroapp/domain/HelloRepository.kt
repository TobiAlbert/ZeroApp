package com.tobidaada.zeroapp.domain

import com.tobidaada.zeroapp.data.model.HelloMessage
import io.reactivex.Single

interface HelloRepository {
    fun sayHello(): Single<HelloMessage>
}