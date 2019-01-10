package com.tobidaada.zeroapp.domain

import com.tobidaada.zeroapp.data.model.HelloMessage

data class HelloResponse(val message: String): DomainMappable<HelloMessage> {
    override fun asDomain(): HelloMessage = HelloMessage(message)
}