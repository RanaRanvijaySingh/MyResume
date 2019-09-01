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
}