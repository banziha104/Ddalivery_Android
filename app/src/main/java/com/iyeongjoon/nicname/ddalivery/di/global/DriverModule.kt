package com.iyeongjoon.nicname.ddalivery.di.global

import android.app.Application
import android.content.Context
import com.iyeongjoon.nicname.data.driver.DataDriver
import dagger.Module
import dagger.Provides
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Named
import javax.inject.Singleton

@Module
class DriverModule{
    @Provides
    @Singleton
    fun provideDataDriver() : DataDriver = DataDriver()
}