package com.assignment.myresume.home.ui

import androidx.lifecycle.MutableLiveData
import com.assignment.myresume.base.BaseViewModelImpl
import com.assignment.myresume.home.domain.GetResumeUseCase
import com.assignment.myresume.utils.Constants
import com.assignment.myresume.utils.NetworkUtils
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    compositeDisposable: CompositeDisposable,
    private val networkUtils: NetworkUtils,
    private val useCase: GetResumeUseCase
) : BaseViewModelImpl(compositeDisposable) {

    val resumeUiLiveData = MutableLiveData<ResumeUi>()
    val progressLiveData = MutableLiveData<Boolean>()
    val retryOptionLiveData = MutableLiveData<String>()

    init {
        getResume()
    }

    fun getResume() {
        if (!networkUtils.isNetworkAvailable()) {
            retryOptionLiveData.value = Constants.Messages.NO_INTERNET
            return
        }
        progressLiveData.value = true
        manageActionDisposables(useCase.execute(null).subscribe({ resumeUi ->
            progressLiveData.value = false
            resumeUiLiveData.value = resumeUi
        }, { error ->
            progressLiveData.value = false
            retryOptionLiveData.value = Constants.Messages.UNABLE_TO_FETCH_DATA
        }))
    }
}