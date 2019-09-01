package com.assignment.myresume.utils

import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DateTimeUtilsTest {

    lateinit var dateTimeUtil: DateTimeUtils

    @Before
    fun setUp() {
        dateTimeUtil = DateTimeUtils()
    }

    @Test
    fun test_getFormattedDate_forValidValue() {
        assertEquals("Aug 2019", dateTimeUtil.getFormattedDate(1567257305))
    }

    @Test
    fun test_getFormattedDate_forInvalid() {
        assertEquals("", dateTimeUtil.getFormattedDate(-1567257305))
    }

    @Test
    fun test_getFormattedDate_forHighValue() {
        assertEquals("May 2051", dateTimeUtil.getFormattedDate(2567257305))
    }

    @Test
    fun test_getDuration_for0AsEndDate() {
        val actualObject = dateTimeUtil.getDuration(1478893204L, 0L)
        val expectedObject = "2 months"
        assertEquals(expectedObject, actualObject)
    }

    @Test
    fun test_getDuration_forEndLessThanStart() {
        val actualObject = dateTimeUtil.getDuration(1478893204L, 1378893204L)
        val expectedObject = ""
        assertEquals(expectedObject, actualObject)
    }

    @Test
    fun test_getDuration_forValid() {
        val actualObject = dateTimeUtil.getDuration(1478893204L, 1778893204L)
        val expectedObject = "9 months"
        assertEquals(expectedObject, actualObject)
    }
}