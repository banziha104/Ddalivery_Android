package com.iyeongjoon.nicname.ddalivery.di.ui.fragments.module

import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HomeModule{
    @Provides
    fun provideHomeViewModelFactory() = HomeViewModelFactory()
}