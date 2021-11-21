package com.masai.lifesaver.ui.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.masai.lifesaver.R
import com.masai.lifesaver.ui.activity.userhome.UserHomeActivity
import com.masai.lifesaver.ui.loginpackage.InstantActionActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay

@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {

    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        auth = Firebase.auth
        window.statusBarColor = Color.parseColor("#fe4a67")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN,
            WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
        )
        setContentView(R.layout.activity_splash_screen)

        Handler().postDelayed({
            Log.d("Abhishek", "onCreate: " + auth.currentUser?.uid)
            if (auth.currentUser == null) {
                val intent = Intent(applicationContext, InstantActionActivity::class.java)
                startActivity(intent)
            } else {
                val intent = Intent(applicationContext, UserHomeActivity::class.java)
                startActivity(intent)
            }
            finish()
        }, 2000)

    }
}