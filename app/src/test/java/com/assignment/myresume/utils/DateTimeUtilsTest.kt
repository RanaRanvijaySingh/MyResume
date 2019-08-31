package com.assignment.myresume.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class DateTimeUtilsTest {

    @Test
    fun test_getFormattedDate_forValidValue() {
        assertEquals("Aug 2019", DateTimeUtils().getFormattedDate(1567257305))
    }

    @Test
    fun test_getFormattedDate_forInvalid() {
        assertEquals("", DateTimeUtils().getFormattedDate(-1567257305))
    }

    @Test
    fun test_getFormattedDate_forHighValue() {
        assertEquals("May 2051", DateTimeUtils().getFormattedDate(2567257305))
    }
}