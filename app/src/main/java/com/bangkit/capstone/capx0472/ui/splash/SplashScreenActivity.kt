package com.bangkit.capstone.capx0472.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.bangkit.capstone.capx0472.R
import com.bangkit.capstone.capx0472.ui.input.InputNameActivity

class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val splashTimeOut:Long = 3000

        Handler(mainLooper).postDelayed({
            startActivity(Intent(this, InputNameActivity::class.java))
            finish()
        }, splashTimeOut)

    }
}