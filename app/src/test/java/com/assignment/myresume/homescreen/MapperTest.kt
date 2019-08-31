package com.assignment.myresume.homescreen

import com.assignment.myresume.TestObjects
import com.assignment.myresume.utils.DateTimeUtils
import com.google.gson.Gson
import org.junit.Assert
import org.junit.Before
import org.junit.Test

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
        val actualObject = mapper.map(TestObjects.resume)
        val expectedObject = TestObjects.resumeUi
        val actualJson = Gson().toJson(actualObject)
        val expectedJson = Gson().toJson(expectedObject)
        Assert.assertEquals(expectedJson, actualJson)
    }

    @Test
    fun test_map_careerSummary() {
        val actualObject = mapper.map(TestObjects.resume).careerSummary
        val expectedObject = TestObjects.resumeUi.careerSummary
        Assert.assertEquals(expectedObject, actualObject)
    }

    @Test
    fun test_map_apiTool() {
        val actualObject = mapper.map(TestObjects.resume).apiTool
        val expectedObject = TestObjects.resumeUi.apiTool
        Assert.assertEquals(expectedObject, actualObject)
    }

    @Test
    fun test_map_languages() {
        val actualObject = mapper.map(TestObjects.resume).languages
        val expectedObject = TestObjects.resumeUi.languages
        Assert.assertEquals(expectedObject, actualObject)
    }
}