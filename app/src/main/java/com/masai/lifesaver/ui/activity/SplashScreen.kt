package com.masai.lifesaver.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.masai.lifesaver.R

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.parseColor("#fe4a67")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        )
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            startActivity(Intent(this, InstantActionActivity::class.java))
            finish()
        }, 2000)

    }
}