package com.masai.lifesaver.ui.activity

import android.graphics.Color
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.masai.lifesaver.R
import kotlinx.android.synthetic.main.activity_booking_details.*

class BookingDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.parseColor("#ff4b67")
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContentView(R.layout.activity_booking_details)

        val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val to = intent.getStringExtra("to")
        val date = intent.getStringExtra("date")
        val time = intent.getStringExtra("time")


        tv_booking_date.text = date
        tv_booking_time.text = time
        tv_name_det.text = name
        tv_from_det.text = from
        tv_to_det.text = to
    }
}