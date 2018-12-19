package com.tobidaada.zeroapp.domain

interface DomainMappable<R> {
    fun asDomain(): R
}
