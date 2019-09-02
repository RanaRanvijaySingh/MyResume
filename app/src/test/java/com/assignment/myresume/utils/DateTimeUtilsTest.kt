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
        assertEquals("Working here", dateTimeUtil.getFormattedDate(-1567257305))
    }

    @Test
    fun test_getFormattedDate_forHighValue() {
        assertEquals("May 2051", dateTimeUtil.getFormattedDate(2567257305))
    }

    @Test
    fun test_getDuration_for0AsEndDate() {
        val actualObject = dateTimeUtil.getDuration(1478893204L, 0L)
        val expectedObject = "2 years 10 months"
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
        val expectedObject = "9 years 7 months"
        assertEquals(expectedObject, actualObject)
    }

    @Test
    fun test_getDuration_forSingleMonth() {
        val actualObject = dateTimeUtil.getDuration(1567435677L, 1570027677L)
        val expectedObject = "1 month"
        assertEquals(expectedObject, actualObject)
    }

    @Test
    fun test_getDuration_forMonths() {
        val actualObject = dateTimeUtil.getDuration(1567435677L, 1572706077L)
        val expectedObject = "2 months"
        assertEquals(expectedObject, actualObject)
    }

    @Test
    fun test_getDuration_forSingleYear() {
        val actualObject = dateTimeUtil.getDuration(1572706077L, 1604328477L)
        val expectedObject = "1 year"
        assertEquals(expectedObject, actualObject)
    }

    @Test
    fun test_getDuration_forM9onths() {
        val actualObject = dateTimeUtil.getDuration(1635864477L, 1698936477L)
        val expectedObject = "2 years"
        assertEquals(expectedObject, actualObject)
    }
}