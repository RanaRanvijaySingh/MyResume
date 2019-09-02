package com.assignment.myresume.base

import io.reactivex.disposables.Disposable

interface BaseViewModel {
    fun manageActionDisposables(disposable: Disposable)
}