package com.masai.lifesaver.ui.activity.userhome

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.masai.lifesaver.R
import com.masai.lifesaver.models.UpComingBookingModel
import kotlinx.android.synthetic.main.fragment_emergency.*
import java.text.SimpleDateFormat
import java.util.*

class NewBookingFragment : Fragment(R.layout.fragment_emergency) {
    private lateinit var gAuth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()
    private var curr_date = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gAuth = FirebaseAuth.getInstance()
        initDate()

        btn_emergency_in.setOnClickListener {
            addToFirebase()
        }
    }

    private fun addToFirebase() {
        val name = etNameSUp.text.toString()
        val address = etAddress_new.text.toString()
        val hospital_Add = et_hospital_add.text.toString()
        val date = etExpDate.text.toString()
        val details = UpComingBookingModel(name, address, hospital_Add, date)


        val uid = gAuth.uid
        if (uid != null) {
            db.collection("user").document(uid).collection("bookings").add(details)
        }
    }

    private fun initDate() {
        curr_date = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())
        etExpDate.setText(curr_date)

        val datePicker =
            MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select date")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .setTheme(R.style.calender_theme)
                .build()

        btn_select_date_exp.setOnClickListener {
            datePicker.show(requireFragmentManager(), "DatePicker")
        }

        datePicker.addOnPositiveButtonClickListener { selecton ->
            val timeZoneUTC = TimeZone.getDefault()
            val offsetFromUTC = timeZoneUTC.getOffset(Date().time) * -1

            val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.UK)
            val date = Date(selecton + offsetFromUTC)
            etExpDate.setText(simpleDateFormat.format(date))
        }
    }
}