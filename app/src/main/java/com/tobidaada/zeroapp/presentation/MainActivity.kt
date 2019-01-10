package com.tobidaada.zeroapp.presentation

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.tobidaada.zeroapp.BuildConfig
import com.tobidaada.zeroapp.R
import com.tobidaada.zeroapp.utils.Consts
import com.tobidaada.zeroapp.utils.showToast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var mViewModel: MainViewModel
    companion object {
        private var TAG = MainActivity::class.java.simpleName
    }
    private lateinit var mRemoteConfig: FirebaseRemoteConfig
    private lateinit var mWelcomeText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mViewModel = ViewModelProviders.of(this@MainActivity).get(MainViewModel::class.java)

        mRemoteConfig =  FirebaseRemoteConfig.getInstance()
        mWelcomeText = welcomeMessageTv

        val remoteConfigSettings = FirebaseRemoteConfigSettings.Builder()
            .setDeveloperModeEnabled(BuildConfig.DEBUG)
            .build()
        mRemoteConfig.setConfigSettings(remoteConfigSettings)
        mRemoteConfig.setDefaults(R.xml.remote_config_defaults)

        var cacheExpiration = 50L // in seconds

        if (BuildConfig.DEBUG) cacheExpiration = 30L

        mRemoteConfig.fetch(cacheExpiration)
            .addOnCompleteListener {
                task ->
                if (task.isSuccessful) {
                    this@MainActivity.showToast("Fetch Successful")
                    mRemoteConfig.activateFetched()
                } else {
                    this@MainActivity.showToast("Fetch Unsuccessful")
                }
                updateRemoteConfigValues()
            }
    }

    private fun updateRemoteConfigValues() {
        var message = mRemoteConfig.getString(Consts.WELCOME_MESSAGE_KEY)
        val shouldMakeUpperCase = mRemoteConfig.getBoolean(Consts.WELCOME_MESSAGE_CAPS_KEY)

        if (shouldMakeUpperCase) message = message.toUpperCase()

        mWelcomeText.text = message
    }
}
