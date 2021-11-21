package com.masai.lifesaver.ui.activity.userhome

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.masai.lifesaver.R
import com.masai.lifesaver.ui.activity.EmergencyActivity
import kotlinx.android.synthetic.main.activity_booking_records.*

class UserHomeFragment : Fragment(R.layout.activity_booking_records) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btnEmergencyfromHome.setOnClickListener {
            startActivity(Intent(requireActivity(),EmergencyActivity::class.java))
        }
    }

}