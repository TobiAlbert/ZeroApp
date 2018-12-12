package com.tobidaada.zeroapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.crashlytics.android.Crashlytics

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val crashButton = Button(this)
        crashButton.apply {
            text =  "Crash!"
            setOnClickListener { crashApp() }
        }

        addContentView(crashButton, ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        ))

    }

    private fun crashApp() {
        Crashlytics.getInstance().crash() // Force Crash
    }
}
