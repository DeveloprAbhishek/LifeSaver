package com.masai.lifesaver.ui.activity.userhome

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.datepicker.MaterialDatePicker
import com.masai.lifesaver.R
import kotlinx.android.synthetic.main.fragment_emergency.*
import java.text.SimpleDateFormat
import java.util.*

class NewBookingFragment : Fragment(R.layout.fragment_emergency) {
    private var curr_date = ""
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initDate()

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