package com.assignment.myresume.utils

import java.lang.StringBuilder
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import javax.inject.Inject

/**
 * Util class to handle all data time conversion.
 */
class DateTimeUtils @Inject constructor() {

    companion object {
        const val DEFAULT_FORMAT = "MMM yyyy"
    }

    /**
     * Function to format given time stamp into default date format. eg. Aug 2019
     */
    fun getFormattedDate(timestamp: Long): String {
        if (timestamp <= 0L)
            return Constants.Messages.WORKING_HERE
        val date = Date(timestamp * 1000)
        val format = SimpleDateFormat(DEFAULT_FORMAT, Locale.getDefault())
        return format.format(date)
    }

    /**
     * Function to calculate duration from start date and end date.
     */
    fun getDuration(startDate: Long, endDate: Long): String {
        var tempEndDate = endDate
        // If end date is 0
        if (endDate <= 0) {
            // Set current time as end date
            tempEndDate = System.currentTimeMillis() / 1000
        }
        var difference = tempEndDate - startDate
        // If difference is in negative of 0
        if (difference <= 0) {
            // Return blank
            return ""
        }
        var totalMonths = difference / (30 * 24 * 60 * 60)
        val yearCount = totalMonths / 12
        val monthCount = totalMonths % 12
        val sb = StringBuilder()
        if (yearCount <= 0) {
            sb.append("$monthCount month")
            // Append 's' if the count is more than 1
            if (monthCount > 1) sb.append("s")
            return sb.toString()
        } else {
            if (monthCount <= 0) {
                sb.append("$yearCount year")
                // Append 's' if the count is more than 1
                if (yearCount > 1) sb.append("s")
                return sb.toString()
            }
            sb.append("$yearCount year")
            // Append 's' if the count is more than 1
            if (yearCount > 1) sb.append("s")
            sb.append(" ")
            sb.append("$monthCount month")
            // Append 's' if the count is more than 1
            if (monthCount > 1) sb.append("s")
            return sb.toString()
        }
    }
}