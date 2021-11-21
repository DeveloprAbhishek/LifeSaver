package com.masai.lifesaver.interfaces

import com.masai.lifesaver.models.BookingRecordModel

interface OnDetailClickListener {
    fun onItemClick(record: BookingRecordModel)
}