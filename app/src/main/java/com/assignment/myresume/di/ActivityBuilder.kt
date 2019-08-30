package com.assignment.myresume.di

import com.assignment.myresume.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [DashboardModule::class])
    abstract fun bindMainActivity(): MainActivity
}