package com.iyeongjoon.nicname.ddalivery.di.global

import com.iyeongjoon.nicname.data.driver.DataDriver
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DriverModule{
    @Provides
    @Singleton
    fun provideDataDriver() : DataDriver = DataDriver()
}