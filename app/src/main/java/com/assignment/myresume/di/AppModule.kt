package com.assignment.myresume.di

import com.assignment.myresume.MyResumeApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    private val application: MyResumeApplication
) {

    @Provides
    @Singleton
    fun provideApplication(): MyResumeApplication {
        return application
    }
}