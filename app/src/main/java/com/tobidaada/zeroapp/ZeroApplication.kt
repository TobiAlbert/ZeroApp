package com.tobidaada.zeroapp

import android.app.Application
import com.crashlytics.android.Crashlytics
import io.fabric.sdk.android.Fabric

class ZeroApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        val fabric = Fabric.Builder(this)
            .kits(Crashlytics())
            .debuggable(BuildConfig.DEBUG) // Enables Crashlytics debugger
            .build()

        Fabric.with(fabric)
    }
}