package com.assignment.myresume.utils

import java.lang.StringBuilder
import javax.inject.Inject

class StringUtils @Inject constructor() {

    /**
     * Function to convert a list of strings into a formatted single string
     */
    fun getListAppearance(careerSummary: List<String>): String {
        val sb = StringBuilder()
        careerSummary.forEach { entry ->
            sb.apply {
                append(Constants.StringValues.DASH_SPACE)
                append(entry)
                append(Constants.StringValues.NEW_LINE)
            }
        }
        return sb.toString()
    }
}