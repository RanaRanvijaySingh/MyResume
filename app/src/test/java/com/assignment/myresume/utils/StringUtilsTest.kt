package com.assignment.myresume.utils

import org.junit.Assert.assertEquals
import org.junit.Test

class StringUtilsTest {

    @Test
    fun test_listAppearance() {
        val actualObject = StringUtils().getListAppearance(listOf<String>("hello", "hi", "how"))
        val expectedObject = "- hello\n- hi\n- how\n"
        assertEquals(expectedObject, actualObject)
    }

    @Test
    fun test_listAppearance_forSingleItem() {
        val actualObject = StringUtils().getListAppearance(listOf<String>("hello"))
        val expectedObject = "- hello\n"
        assertEquals(expectedObject, actualObject)
    }

    @Test
    fun test_listAppearance_forEmpty() {
        val actualObject = StringUtils().getListAppearance(listOf<String>())
        val expectedObject = ""
        assertEquals(expectedObject, actualObject)
    }

    @Test
    fun test_listAppearance_forBlank() {
        val actualObject = StringUtils().getListAppearance(listOf<String>(""))
        val expectedObject = ""
        assertEquals(expectedObject, actualObject)
    }

    @Test
    fun test_listAppearance_forSpace() {
        val actualObject = StringUtils().getListAppearance(listOf<String>("   "))
        val expectedObject = ""
        assertEquals(expectedObject, actualObject)
    }
}