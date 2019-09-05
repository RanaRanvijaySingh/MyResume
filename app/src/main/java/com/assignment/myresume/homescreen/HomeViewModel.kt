package com.assignment.myresume.homescreen

import androidx.lifecycle.MutableLiveData
import com.assignment.myresume.base.BaseViewModelImpl
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

    /**
     * Function to delegate call to use case to get the resume data.
     */
    fun getResume() {
        // Check for the network call update the live data in case of no network
        if (!networkUtils.isNetworkAvailable()) {
            retryOptionLiveData.value = Constants.Messages.NO_INTERNET
            return
        }
        // Update the progress bar view
        progressLiveData.value = true
        manageActionDisposables(useCase.execute(null).subscribe({ resumeUi ->
            // Handle success case
            progressLiveData.value = false
            resumeUiLiveData.value = resumeUi
        }, {
            // Handle error case
            progressLiveData.value = false
            retryOptionLiveData.value = Constants.Messages.UNABLE_TO_FETCH_DATA
        }))
    }
}