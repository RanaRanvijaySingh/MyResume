package com.assignment.myresume.homescreen

import com.assignment.myresume.testutils.TestObjects
import com.assignment.myresume.service.ResumeService
import com.google.gson.Gson
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import org.junit.Before

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ResumeRepositoryTest {

    @Mock
    lateinit var service: ResumeService
    lateinit var repository: ResumeRepository
    lateinit var gson: Gson

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = ResumeRepository(service)
        gson = Gson()
    }

    @Test
    fun test_getResume() {
        whenever(service.getResume()).thenReturn(Flowable.just(TestObjects.resume))
        val actual = repository.getResume()
        val expected = Flowable.just(TestObjects.resume)
        val actualString = gson.toJson(actual)
        val expectedString = gson.toJson(expected)
        assertEquals(expectedString, actualString)
    }
}