package com.masai.lifesaver.ui.activity.userhome

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.masai.lifesaver.R
import com.masai.lifesaver.ui.activity.EmergencyActivity
import kotlinx.android.synthetic.main.activity_booking_records.*


class UserHomeFragment : Fragment(R.layout.activity_booking_records) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_call.setOnClickListener {
            val callIntent = Intent(Intent.ACTION_CALL)
            callIntent.data = Uri.parse("tel:108")
            if (ActivityCompat.checkSelfPermission(
                    requireActivity(),
                    Manifest.permission.CALL_PHONE
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                if (ActivityCompat.shouldShowRequestPermissionRationale(
                        requireActivity(),
                        Manifest.permission.CALL_PHONE
                    )
                ) {
                } else {
                    ActivityCompat.requestPermissions(
                        requireActivity(), arrayOf(Manifest.permission.CALL_PHONE),
                        7
                    )
                }
            }
            startActivity(callIntent)
        }


        btnEmergencyfromHome.setOnClickListener {
            startActivity(Intent(requireActivity(), EmergencyActivity::class.java))
        }
    }

}