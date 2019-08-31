package com.assignment.myresume.homescreen.companyscreen

import com.assignment.myresume.testutils.TestObjects
import com.assignment.myresume.service.ResumeService
import com.google.gson.Gson
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CompanyRepositoryTest {

    @Mock
    lateinit var service: ResumeService
    lateinit var repository: CompanyRepository
    lateinit var gson: Gson

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        repository = CompanyRepository(service)
        gson = Gson()
    }

    @Test
    fun test_getResume() {
        whenever(service.getCompany(TestObjects.companyUrl)).thenReturn(Flowable.just(TestObjects.companyDetail))
        val actual = repository.getCompany(TestObjects.companyUrl)
        val expected = Flowable.just(TestObjects.companyDetail)
        val actualString = gson.toJson(actual)
        val expectedString = gson.toJson(expected)
        assertEquals(expectedString, actualString)
    }
}