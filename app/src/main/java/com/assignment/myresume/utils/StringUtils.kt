package com.assignment.myresume.utils

import java.lang.StringBuilder
import javax.inject.Inject

class StringUtils @Inject constructor() {

    /**
     * Function to convert a list of strings into a formatted single string object
     */
    fun getListAppearance(list: List<String>): String {
        if (list.isNullOrEmpty()){
            return Constants.StringValues.BLANK
        }
        val sb = StringBuilder()
        list.forEach { entry ->
            if (!entry.trim().isNullOrEmpty()) {
                sb.apply {
                    append(Constants.StringValues.DASH_SPACE)
                    append(entry)
                    append(Constants.StringValues.NEW_LINE)
                }
            }
        }
        return sb.toString()
    }
}