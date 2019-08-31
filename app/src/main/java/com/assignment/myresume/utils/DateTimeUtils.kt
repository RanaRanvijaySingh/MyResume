package com.assignment.myresume.utils

import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class DateTimeUtils @Inject constructor() {

    companion object {
        const val DEFAULT_FORMAT = "MMM yyyy"
    }

    fun getFormattedDate(timestamp: Long): String {
        if (timestamp <= 0L)
            return ""
        val date = Date(timestamp * 1000)
        val format = SimpleDateFormat(DEFAULT_FORMAT, Locale.getDefault())
        return format.format(date)
    }
}