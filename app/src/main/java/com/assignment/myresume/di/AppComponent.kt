package com.assignment.myresume.di

import com.assignment.myresume.MainActivity
import com.assignment.myresume.MyResumeApplication
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class
    ]
)
interface AppComponent {
    fun inject(application: MyResumeApplication)

    fun inject(mainActivity: MainActivity)
}