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
            "Royal Mangal Hotel",
            "SMS Hospital",
            "12-12-21",
            "9AM",
            "Amol",
            7845121215
        )
        val ite2 = BookingRecordModel(
            "Royal Mangal Hotel",
            "SMS Hospital",
            "12-11-21",
            "9AM",
            "Amol",
            7845121215
        )
        val item3 = BookingRecordModel(
            "Royal Mangal Hotel",
            "SMS Hospital",
            "12-12-21",
            "9AM",
            "Amol",
            7845121215
        )
        val ite4 = BookingRecordModel(
            "Royal Mangal Hotel",
            "SMS Hospital",
            "12-12-12",
            "9AM",
            "Amol",
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