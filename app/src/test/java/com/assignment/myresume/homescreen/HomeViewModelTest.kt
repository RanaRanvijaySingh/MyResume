package com.assignment.myresume.homescreen

import com.assignment.myresume.homescreen.companyscreen.CompanyViewModel
import com.assignment.myresume.homescreen.companyscreen.GetCompanyUseCase
import com.assignment.myresume.testutils.TestObjects
import com.assignment.myresume.utils.Constants
import com.assignment.myresume.utils.NetworkUtils
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
class HomeViewModelTest {
    lateinit var viewModel: HomeViewModel

    @Mock
    lateinit var networkUtils: NetworkUtils

    @Mock
    lateinit var useCase: GetResumeUseCase

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = HomeViewModel(
            compositeDisposable = CompositeDisposable(),
            networkUtils = networkUtils,
            useCase = useCase
        )
    }

    @Test
    fun test_getCompanyDetail() {
        whenever(networkUtils.isNetworkAvailable()).thenReturn(true)
        whenever(useCase.execute(null))
            .thenReturn(Flowable.just(TestObjects.resumeUi))
        viewModel.getResume()
        val actual = viewModel.resumeUiLiveData.value
        val expected = TestObjects.resumeUi
        assertEquals(expected, actual)
    }

    @Test
    fun test_getCompanyDetail_forError() {
        whenever(networkUtils.isNetworkAvailable()).thenReturn(true)
        whenever(useCase.execute(null))
            .thenReturn(Flowable.error(Exception(Constants.INVALID_REQUEST)))
        viewModel.getResume()
        val actual = viewModel.retryOptionLiveData.value
        val expected = Constants.Messages.UNABLE_TO_FETCH_DATA
        assertEquals(expected, actual)
    }

    @Test
    fun test_getCompanyDetail_forNoNetwork() {
        whenever(networkUtils.isNetworkAvailable()).thenReturn(false)
        viewModel.getResume()
        val actual = viewModel.retryOptionLiveData.value
        val expected = "No internet"
        assertEquals(expected, actual)
    }
}