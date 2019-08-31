package com.assignment.myresume.homescreen

import com.assignment.myresume.testutils.TestObjects
import com.assignment.myresume.testutils.TestSchedulerProvider
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetResumeUseCaseTest {

    @Mock
    lateinit var mapper: Mapper

    @Mock
    lateinit var companyRepository: ResumeRepository

    lateinit var useCase: GetResumeUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        useCase = GetResumeUseCase(
            companyRepository,
            mapper,
            TestSchedulerProvider(),
            TestSchedulerProvider()
        )
    }

    @Test
    fun test_getResume() {
        whenever(companyRepository.getResume())
            .thenReturn(Flowable.just(TestObjects.resume))
        whenever(mapper.map(TestObjects.resume))
            .thenReturn(TestObjects.resumeUi)
        val actual = useCase.execute(null).test().values()[0]
        val expected = TestObjects.resumeUi
        Assert.assertEquals(expected, actual)
    }
}