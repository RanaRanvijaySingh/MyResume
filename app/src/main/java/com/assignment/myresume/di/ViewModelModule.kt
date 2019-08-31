package com.assignment.myresume.di

import androidx.lifecycle.ViewModelProvider
import com.assignment.myresume.base.BaseViewModel
import com.assignment.myresume.homescreen.HomeViewModel
import com.assignment.myresume.homescreen.companyscreen.CompanyViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
internal abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    protected abstract fun registerHomeViewModel(registerViewModal: HomeViewModel): BaseViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CompanyViewModel::class)
    protected abstract fun registerCompanyViewModel(registerViewModal: CompanyViewModel): BaseViewModel
}