package com.example.spacexapplication

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // Gunakan handler untuk menunda perpindahan ke aktivitas berikutnya
        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_DELAY) // SPLASH_DELAY adalah waktu penundaan dalam milidetik
    }

    companion object {
        private const val SPLASH_DELAY = 3000L // Misalnya, 3000 milidetik (3 detik)
    }
}