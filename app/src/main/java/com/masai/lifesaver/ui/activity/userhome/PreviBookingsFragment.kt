package com.masai.lifesaver.ui.activity.userhome

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.masai.lifesaver.R
import com.masai.lifesaver.models.BookingRecordModel
import com.masai.lifesaver.recyclerview.RecordAdapter
import kotlinx.android.synthetic.main.fragment_previ_bookings.*

class PreviBookingsFragment : Fragment(R.layout.fragment_previ_bookings) {

    private var recordList = ArrayList<BookingRecordModel>()
    private lateinit var gAuth: FirebaseAuth
    private val db = FirebaseFirestore.getInstance()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        gAuth = FirebaseAuth.getInstance()
        val uid = gAuth.uid
        if (uid != null) {
            db.collection("user").document(uid).collection("bookings").get().addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d("Abhishek", "${document.id} => ${document.data}")
                }
            }.addOnFailureListener { exception ->
                    Log.w("Abhishek", "Error getting documents: ", exception)
                }
        }

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