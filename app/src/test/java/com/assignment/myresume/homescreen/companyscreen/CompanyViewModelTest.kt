package com.assignment.myresume.homescreen.companyscreen

import com.assignment.myresume.testutils.TestObjects
import com.assignment.myresume.utils.Constants
import com.assignment.myresume.utils.NetworkUtils
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class CompanyViewModelTest {

    lateinit var viewModel: CompanyViewModel

    @Mock
    lateinit var networkUtils: NetworkUtils

    @Mock
    lateinit var useCase: GetCompanyUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = CompanyViewModel(
            compositeDisposable = CompositeDisposable(),
            networkUtils = networkUtils,
            useCase = useCase
        )
    }

    @Test
    fun test_getCompanyDetail() {
        whenever(networkUtils.isNetworkAvailable()).thenReturn(true)
        whenever(useCase.execute(TestObjects.companyUrl))
            .thenReturn(Flowable.just(TestObjects.companyDetailUi))
        viewModel.getCompanyDetail(TestObjects.companyUrl)
        val actual = viewModel.companyDetailLiveData.value
        val expected = TestObjects.companyDetailUi
        assertEquals(expected, actual)
        assertEquals(false, viewModel.progressLiveData.value)
    }

    @Test
    fun test_getCompanyDetail_forError() {
        whenever(networkUtils.isNetworkAvailable()).thenReturn(true)
        whenever(useCase.execute(TestObjects.companyUrl))
            .thenReturn(Flowable.error(Exception(Constants.INVALID_REQUEST)))
        viewModel.getCompanyDetail(TestObjects.companyUrl)
        val actual = viewModel.retryOptionLiveData.value
        val expected = Constants.Messages.UNABLE_TO_FETCH_DATA
        assertEquals(expected, actual)
    }

    @Test
    fun test_getCompanyDetail_forNoNetwork() {
        whenever(networkUtils.isNetworkAvailable()).thenReturn(false)
        viewModel.getCompanyDetail(TestObjects.companyUrl)
        val actual = viewModel.retryOptionLiveData.value
        val expected = "No internet"
        assertEquals(expected, actual)
    }
}