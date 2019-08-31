package com.assignment.myresume.home.ui

import androidx.lifecycle.MutableLiveData
import com.assignment.myresume.base.BaseViewModelImpl
import com.assignment.myresume.home.domain.GetResumeUseCase
import com.assignment.myresume.home.domain.ResumeUi
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    private val compositeDisposable: CompositeDisposable,
    private val useCase: GetResumeUseCase
) : BaseViewModelImpl(compositeDisposable) {

    val resumeUiLiveData = MutableLiveData<ResumeUi>()

    init {
        getResume()
    }

    fun getResume() {
        manageActionDisposables(useCase.execute(null).subscribe({ resumeUi ->
            resumeUiLiveData.value = resumeUi
        }, { error ->

        }))
    }
}