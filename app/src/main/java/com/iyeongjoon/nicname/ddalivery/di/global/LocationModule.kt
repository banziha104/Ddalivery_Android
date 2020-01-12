package com.iyeongjoon.nicname.ddalivery.di.global

import android.app.Application
import com.iyeongjoon.nicname.core.gps.LocationEvent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocationModule{
    @Provides
    @Singleton
    fun provideLocationEvent(context : Application) = LocationEvent(context)
}