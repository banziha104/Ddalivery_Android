package com.iyeongjoon.nicname.ddalivery

import com.iyeongjoon.nicname.ddalivery.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication


class DdaliveryApplication : DaggerApplication(){
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}