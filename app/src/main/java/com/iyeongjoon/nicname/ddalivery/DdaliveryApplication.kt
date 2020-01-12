package com.iyeongjoon.nicname.ddalivery

import com.iyeongjoon.nicname.ddalivery.di.DaggerAppComponent
import com.iyeongjoon.nicname.ddalivery.service.LocationService
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import org.jetbrains.anko.stopService


class DdaliveryApplication : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }

    override fun onTerminate() {
        super.onTerminate()
        stopService<LocationService>()
    }
}