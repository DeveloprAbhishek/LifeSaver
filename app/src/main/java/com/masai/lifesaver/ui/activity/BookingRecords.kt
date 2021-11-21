package com.masai.lifesaver.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.masai.lifesaver.R
import kotlinx.android.synthetic.main.activity_booking_records.*

class BookingRecords : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking_records)

        btn_eergency.setOnClickListener {
            startActivity(Intent(this,EmergencyActivity::class.java))
        }

    }
}