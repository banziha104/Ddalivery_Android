package com.iyeongjoon.nicname.ddalivery.di.ui.service

import com.iyeongjoon.nicname.ddalivery.di.ui.fragments.module.HomeModule
import com.iyeongjoon.nicname.ddalivery.service.LocationService
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ServiceBinder {
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun bindLocationServiceModule(): LocationService
}