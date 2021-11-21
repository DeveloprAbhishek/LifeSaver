package com.masai.lifesaver.ui.activity.userhome

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.masai.lifesaver.R
import com.masai.lifesaver.interfaces.OnDetailClickListener
import com.masai.lifesaver.models.BookingRecordModel
import com.masai.lifesaver.recyclerview.RecordAdapter
import com.masai.lifesaver.ui.activity.BookingDetailsActivity
import kotlinx.android.synthetic.main.fragment_previ_bookings.*

class PreviBookingsFragment : Fragment(R.layout.fragment_previ_bookings), OnDetailClickListener {

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
                    val name=document.data.get("name").toString()
                    val to=document.data.get("to").toString()
                    val from=document.data.get("from").toString()
                    val date=document.data.get("date").toString()
                    val time=document.data.get("time").toString()
                    val mobileNum=document.data.get("mobile").toString()
                    val item = BookingRecordModel(from, to, date, time, name,mobileNum)
                    recordList.add(item)
                    Log.d("abhsihek",name+to+from+time)
                }
                setRecyclerView()
            }.addOnFailureListener { exception ->
                    Log.w("Abhishek", "Error getting documents: ", exception)
            }
        }

    }

    private fun setRecyclerView() {
        recyclerViewRecords.adapter = RecordAdapter(recordList,this)
        recyclerViewRecords.layoutManager = LinearLayoutManager(requireActivity())

    }

    override fun onItemClick(record: BookingRecordModel) {
        val intent = Intent(requireActivity(), BookingDetailsActivity::class.java)
        intent.putExtra("date", record.date)
        intent.putExtra("time", record.time)
        intent.putExtra("name", record.name)
        intent.putExtra("from", record.from)
        intent.putExtra("to", record.to)
        startActivity(intent)
    }
}