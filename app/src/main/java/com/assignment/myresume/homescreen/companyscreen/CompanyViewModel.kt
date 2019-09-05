package com.assignment.myresume.homescreen.companyscreen

import androidx.lifecycle.MutableLiveData
import com.assignment.myresume.base.BaseViewModelImpl
import com.assignment.myresume.utils.Constants
import com.assignment.myresume.utils.NetworkUtils
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class CompanyViewModel @Inject constructor(
    compositeDisposable: CompositeDisposable,
    private val networkUtils: NetworkUtils,
    private val useCase: GetCompanyUseCase
) : BaseViewModelImpl(compositeDisposable) {
    val companyDetailLiveData = MutableLiveData<CompanyDetailUi>()
    val progressLiveData = MutableLiveData<Boolean>()
    val retryOptionLiveData = MutableLiveData<String>()

    /**
     * Function to delegate call to use case to get the resume data.
     */
    fun getCompanyDetail(companyDetailUrl: String) {
        // Check for the network call update the live data in case of no network
        if (!networkUtils.isNetworkAvailable()) {
            retryOptionLiveData.value = Constants.Messages.NO_INTERNET
            return
        }
        // Update the progress bar view
        progressLiveData.value = true
        manageActionDisposables(useCase.execute(companyDetailUrl).subscribe({
            // Handle success case
            progressLiveData.value = false
            companyDetailLiveData.value = it
        }, {
            // Handle error case
            progressLiveData.value = false
            retryOptionLiveData.value = Constants.Messages.UNABLE_TO_FETCH_DATA
        }))
    }
}
