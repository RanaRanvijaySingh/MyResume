package com.assignment.myresume.home.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.assignment.myresume.base.BaseViewModelImpl
import com.assignment.myresume.home.domain.GetResumeUseCase
import com.assignment.myresume.home.domain.ResumeUi
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class HomeViewModel @Inject constructor(
    compositeDisposable: CompositeDisposable,
    private val useCase: GetResumeUseCase
) : BaseViewModelImpl(compositeDisposable) {

    val resumeUiLiveData = MutableLiveData<ResumeUi>()
    val progressLiveData = MutableLiveData<Boolean>()

/*    init {
        getResume()
    }*/

    fun getResume() {
        progressLiveData.value = true
        manageActionDisposables(useCase.execute(null).subscribe({ resumeUi ->
            progressLiveData.value = false
            resumeUiLiveData.value = resumeUi
        }, { error ->
            progressLiveData.value = false
            Log.i(">>>", error.toString())
        }))
    }
}