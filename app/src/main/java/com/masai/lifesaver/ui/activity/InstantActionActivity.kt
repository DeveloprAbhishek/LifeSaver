package com.masai.lifesaver.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masai.lifesaver.R
import com.masai.lifesaver.ui.activity.userhome.UserHomeActivity
import kotlinx.android.synthetic.main.activity_instant_action.*

class InstantActionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_instant_action)


        btnInstantEmergency.setOnClickListener {

            startActivity(Intent(this,EmergencyActivity::class.java))

        }

        btn_login_as_user.setOnClickListener {
            startActivity(Intent(this,UserHomeActivity::class.java))
        }

    }
}