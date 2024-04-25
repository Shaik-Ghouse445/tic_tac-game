package com.example.tictacgame

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictacgame.databinding.ActivitySplashscreenBinding

class splashscreen : AppCompatActivity() {
    private  val  binding: ActivitySplashscreenBinding by lazy {
        ActivitySplashscreenBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this,Log_in_page::class.java))
        },3000)
    }
}