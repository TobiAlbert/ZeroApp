package com.tobidaada.zeroapp.koin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.tobidaada.zeroapp.R
import org.koin.android.ext.android.inject
import org.koin.android.scope.ext.android.bindScope
import org.koin.android.scope.ext.android.getOrCreateScope

class MyScopeActivity : AppCompatActivity() {

    // inject MyScopePresenter from "session" scope
    val scopePresenter: MyScopePresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_scope)

        // bind "session" scope to component lifecycle
        bindScope(getOrCreateScope("session"))
    }
}
