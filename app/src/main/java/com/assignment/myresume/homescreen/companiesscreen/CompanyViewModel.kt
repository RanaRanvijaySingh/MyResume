package com.assignment.myresume.homescreen.companiesscreen

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
    val companyDetailUi = MutableLiveData<CompanyDetailUi>()
    val progressLiveData = MutableLiveData<Boolean>()
    val retryOptionLiveData = MutableLiveData<String>()

    init {
        getCompanyDetail()
    }

    fun getCompanyDetail() {
        if (!networkUtils.isNetworkAvailable()) {
            retryOptionLiveData.value = Constants.Messages.NO_INTERNET
            return
        }
        progressLiveData.value = true
        manageActionDisposables(useCase.execute(null).subscribe({
            progressLiveData.value = false
            companyDetailUi.value = it
        }, { error ->
            progressLiveData.value = false
            retryOptionLiveData.value = Constants.Messages.UNABLE_TO_FETCH_DATA
        }))
    }
}