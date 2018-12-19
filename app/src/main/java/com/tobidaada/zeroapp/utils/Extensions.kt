package com.tobidaada.zeroapp.utils

import android.content.Context
import android.widget.Toast
import com.tobidaada.zeroapp.domain.DomainMappable
import io.reactivex.Single

fun <T: DomainMappable<R>, R> Single<T>.mapToDomain(): Single<R> = this.map {
    it.asDomain()
}

// Context Extensions
fun Context.showToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT)
        .show()
}