package com.assignment.myresume.rx

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

@Module
class RxModule {

    @Singleton
    @Provides
    @MainThreadScheduler
    fun provideMainThreadSchedulerProvider(): SchedulerProvider {
        return MainThreadSchedulerProvider()
    }

    @Singleton
    @Provides
    @IoThreadScheduler
    fun provideIoThreadSchedulerProvider(): SchedulerProvider {
        return IoThreadSchedulerProvider()
    }

    @Provides
    fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}
