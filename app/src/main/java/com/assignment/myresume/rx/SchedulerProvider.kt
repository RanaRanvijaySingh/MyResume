package com.assignment.myresume.rx

import io.reactivex.Scheduler

interface SchedulerProvider {
    fun provideSchedulerProvider(): Scheduler
}