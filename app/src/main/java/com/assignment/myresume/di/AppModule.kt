package com.assignment.myresume.di

import android.app.Application
import android.content.Context
import com.assignment.myresume.MyResumeApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(
    private val application: MyResumeApplication
) {

   /* @Provides
    @Singleton
    internal fun provideContext(application: Application): Context {
        return application
    }*/
}