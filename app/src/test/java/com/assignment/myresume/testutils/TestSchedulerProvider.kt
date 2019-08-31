package com.assignment.myresume.testutils

import com.assignment.myresume.rx.SchedulerProvider
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestSchedulerProvider : SchedulerProvider {
    override fun provideSchedulerProvider(): Scheduler {
        return Schedulers.trampoline()
    }
}