package com.assignment.myresume.homescreen.companyscreen

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
class GetCompanyUseCaseTest {

    @Mock
    lateinit var mapper: Mapper

    @Mock
    lateinit var companyRepository: CompanyRepository

    lateinit var useCase: GetCompanyUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        useCase = GetCompanyUseCase(
            companyRepository,
            mapper,
            TestSchedulerProvider(),
            TestSchedulerProvider()
        )
    }

    @Test
    fun test_getResume() {
        whenever(companyRepository.getCompany(TestObjects.companyUrl))
            .thenReturn(Flowable.just(TestObjects.companyDetail))
        whenever(mapper.map(TestObjects.companyDetail))
            .thenReturn(TestObjects.companyDetailUi)
        val actual = useCase.execute(TestObjects.companyUrl).test().values()[0]
        val expected = TestObjects.companyDetailUi
        Assert.assertEquals(expected, actual)
    }
}