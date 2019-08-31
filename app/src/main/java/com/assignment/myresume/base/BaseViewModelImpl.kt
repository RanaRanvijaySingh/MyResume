package com.assignment.myresume.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModelImpl(
    private val compositeDisposable: CompositeDisposable
) : BaseViewModel, ViewModel() {

    final override fun manageActionDisposables(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        if (!compositeDisposable.isDisposed)
            compositeDisposable.clear()
    }
}
