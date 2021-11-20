package com.masai.lifesaver.ui.activity.userhome

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.lifesaver.R
import com.masai.lifesaver.models.BookingRecordModel
import com.masai.lifesaver.recyclerview.RecordAdapter
import kotlinx.android.synthetic.main.fragment_previ_bookings.*

class PreviBookingsFragment : Fragment(R.layout.fragment_previ_bookings) {
    private var recordList = ArrayList<BookingRecordModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = BookingRecordModel(
            "Abhishek Colony",
            "SMS Hospital",
            "12-12-12",
            "9AM",
            "Anol",
            7845121215
        )
        val ite2 = BookingRecordModel(
            "Abhishek Colony",
            "SMS Hospital",
            "12-12-12",
            "9AM",
            "Anol",
            7845121215
        )
        val item3 = BookingRecordModel(
            "Abhishek Colony",
            "SMS Hospital",
            "12-12-12",
            "9AM",
            "Anol",
            7845121215
        )
        val ite4 = BookingRecordModel(
            "Abhishek Colony",
            "SMS Hospital",
            "12-12-12",
            "9AM",
            "Anol",
            7845121215
        )
        recordList.add(item)
        recordList.add(ite2)
        recordList.add(ite4)
        recordList.add(item3)
        setRecyclerView()

    }

    private fun setRecyclerView() {
        recyclerViewRecords.adapter = RecordAdapter(recordList)
        recyclerViewRecords.layoutManager = LinearLayoutManager(requireActivity())
    }
}