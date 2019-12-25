package com.iyeongjoon.nicname.ddalivery.di

import android.content.Context
import com.iyeongjoon.nicname.ddalivery.DdaliveryApplication
import com.iyeongjoon.nicname.ddalivery.di.global.NetworkModule
import com.jiwoo.choi.nanumcar.di.global.ApiModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


// 의존성 컴포넌트
@Singleton
@Component(modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ApiModule::class,
        NetworkModule::class
        ))
interface AppComponent : AndroidInjector<DdaliveryApplication> {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app : Context) : Builder
        fun build() : AppComponent
    }
}