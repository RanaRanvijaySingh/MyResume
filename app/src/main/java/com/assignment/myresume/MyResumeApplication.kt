package com.assignment.myresume

import android.app.Application
import com.assignment.myresume.di.ApiModule
import com.assignment.myresume.di.AppComponent
import com.assignment.myresume.di.AppModule
import com.assignment.myresume.di.DaggerAppComponent

class MyResumeApplication : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }

    override fun onCreate() {
        super.onCreate()
        // Initialize Dagger
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
            .apiModule(ApiModule())
            .build()
    }
}