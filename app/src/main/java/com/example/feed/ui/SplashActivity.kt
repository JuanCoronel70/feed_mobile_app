package com.example.feed.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import com.example.feed.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class SplashActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        // ================ Ui initialization =================== //
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        // ================ Main coroutine launch =================== //
        CoroutineScope(Dispatchers.Main).launch {

            delay(4000L)

            startActivity(Intent(this@SplashActivity, LoginActivity::class.java))

        }
    }


}