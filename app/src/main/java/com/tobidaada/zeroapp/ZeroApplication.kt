package com.tobidaada.zeroapp

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.tobidaada.zeroapp.config.di.appModule
import io.fabric.sdk.android.Fabric
import org.koin.android.ext.android.startKoin

class ZeroApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        val fabric = Fabric.Builder(this)
            .kits(Crashlytics())
            .debuggable(BuildConfig.DEBUG) // Enables Crashlytics debugger
            .build()

        Fabric.with(fabric)

        startKoin(this, listOf(appModule))
    }
}