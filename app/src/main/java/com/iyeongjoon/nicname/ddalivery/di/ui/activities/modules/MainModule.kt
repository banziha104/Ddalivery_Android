package com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules

import com.iyeongjoon.nicname.ddalivery.ui.activities.main.MainViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MainModule{
    @Provides
    fun provideMainViewModelFactory() = MainViewModelFactory()
}