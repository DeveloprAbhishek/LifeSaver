package com.masai.lifesaver.ui.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import com.masai.lifesaver.R
import kotlinx.android.synthetic.main.activity_booking_details.*

class BookingDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = Color.parseColor("#ff4b67")
        supportActionBar?.hide()
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        setContentView(R.layout.activity_booking_details)

        btn_call_care.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:7845845799")
            if (ActivityCompat.checkSelfPermission(
                    this,
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        this,
                        Manifest.permission.CALL_PHONE
                    )
                ) {
                } else {
                    ActivityCompat.requestPermissions(
                        this, arrayOf(Manifest.permission.CALL_PHONE),
                        7
                    )
                }
            }
            startActivity(callIntent)
        }

        //val name = intent.getStringExtra("name")
        val from = intent.getStringExtra("from")
        val to = intent.getStringExtra("to")
        val date = intent.getStringExtra("date")
        val time = intent.getStringExtra("time")


        tv_booking_date.text = date
        tv_booking_time.text = time
        //tv_name_det.text = name
        tv_from_det.text = from
        tv_to_det.text = to
    }
}