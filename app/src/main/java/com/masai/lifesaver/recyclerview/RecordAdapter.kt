package com.masai.lifesaver.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.masai.lifesaver.R
import com.masai.lifesaver.interfaces.OnDetailClickListener
import com.masai.lifesaver.models.BookingRecordModel
import kotlinx.android.synthetic.main.booking_rec_item_layout.view.*

class RecordAdapter(
    private val recordList: ArrayList<BookingRecordModel>,
    val clickListener: OnDetailClickListener
) :
    RecyclerView.Adapter<RecordAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.booking_rec_item_layout, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = recordList[position]
        holder.setData(item)
        holder.item_clickable.setOnClickListener {
            clickListener.onItemClick(item)
        }
    }

    override fun getItemCount(): Int {
        return recordList.size
    }

    class ViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView) {

        val item_clickable = itemView.findViewById<LinearLayout>(R.id.item_clickable)
        fun setData(item: BookingRecordModel) {
            itemView.apply {
                tv_record_date.text = item.date
                tv_record_time.text = item.time
                tv_address_from.text = item.from
                tv_address_to.text = item.to
            }
        }
    }
}