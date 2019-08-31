package com.assignment.myresume.di

import com.assignment.myresume.home.ui.MainActivity
import com.assignment.myresume.MyResumeApplication
import com.assignment.myresume.rx.RxModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        ApiModule::class,
        RxModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {
    fun inject(application: MyResumeApplication)

    fun inject(mainActivity: MainActivity)
}
