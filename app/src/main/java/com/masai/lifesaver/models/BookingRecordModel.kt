package com.masai.lifesaver.models

data class BookingRecordModel(
    var from: String = "",
    var to: String = "",
    var date: String = "",
    var time: String = "",
    var name: String = "",
    var mobile: Long = 0
)