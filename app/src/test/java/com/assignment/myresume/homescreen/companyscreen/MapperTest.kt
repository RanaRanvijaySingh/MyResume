package com.assignment.myresume.homescreen.companiesscreen

import com.assignment.myresume.testutils.TestObjects
import com.assignment.myresume.homescreen.companyscreen.Mapper
import com.assignment.myresume.utils.DateTimeUtils
import com.google.gson.Gson
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MapperTest {

    lateinit var mapper: Mapper

    @Before
    fun setUp() {
        mapper = Mapper(DateTimeUtils())
    }

    /**
     * This test case covers all the functions in mapper class.
     * We can similarly write other test cases for invalid or different json response.
     */
    @Test
    fun test_map_forValidValues() {
        val actualObject = mapper.map(TestObjects.companyDetail)
        val expectedObject = TestObjects.companyDetailUi
        val actualJson = Gson().toJson(actualObject)
        val expectedJson = Gson().toJson(expectedObject)
        assertEquals(expectedJson, actualJson)
    }

    @Test
    fun test_map_designations() {
        val actualObject = mapper.map(TestObjects.companyDetail).designations
        val expectedObject = TestObjects.companyDetailUi.designations
        val actualJson = Gson().toJson(actualObject)
        val expectedJson = Gson().toJson(expectedObject)
        assertEquals(expectedJson, actualJson)
    }

    @Test
    fun test_map_startDate() {
        val actualObject = mapper.map(TestObjects.companyDetail).startDate
        val expectedObject = TestObjects.companyDetailUi.startDate
        assertEquals(expectedObject, actualObject)
    }

    @Test
    fun test_map_endDate() {
        val actualObject = mapper.map(TestObjects.companyDetail).endDate
        val expectedObject = TestObjects.companyDetailUi.endDate
        assertEquals(expectedObject, actualObject)
    }
}