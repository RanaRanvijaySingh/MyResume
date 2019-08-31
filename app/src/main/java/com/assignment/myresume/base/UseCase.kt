package com.assignment.myresume.base

import com.assignment.myresume.rx.IoThreadSchedulerProvider
import com.assignment.myresume.rx.MainThreadSchedulerProvider
import com.assignment.myresume.rx.SchedulerProvider
import io.reactivex.Flowable
import java.util.concurrent.TimeUnit

abstract class UseCase<REQUEST, RESPONSE> constructor(
    private val subscribeOnScheduler: SchedulerProvider = IoThreadSchedulerProvider(),
    private val observeOnScheduler: SchedulerProvider = MainThreadSchedulerProvider()
) {

    fun execute(request: REQUEST?): Flowable<RESPONSE> {
        return createObservable(request)
            .subscribeOn(subscribeOnScheduler.provideSchedulerProvider())
            .observeOn(observeOnScheduler.provideSchedulerProvider())
    }

    fun executeWithIntervalTimer(request: REQUEST?, delay: Long): Flowable<RESPONSE> {
        return Flowable.timer(delay, TimeUnit.MILLISECONDS).flatMap {
            createObservable(request)
                .subscribeOn(subscribeOnScheduler.provideSchedulerProvider())
                .observeOn(observeOnScheduler.provideSchedulerProvider())
        }
    }

    protected abstract fun createObservable(request: REQUEST?): Flowable<RESPONSE>
}
