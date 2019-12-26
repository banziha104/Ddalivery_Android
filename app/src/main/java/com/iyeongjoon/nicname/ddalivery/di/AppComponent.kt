package com.iyeongjoon.nicname.ddalivery.di

import android.content.Context
import com.iyeongjoon.nicname.ddalivery.DdaliveryApplication
import com.iyeongjoon.nicname.ddalivery.di.global.NetworkModule
import com.iyeongjoon.nicname.ddalivery.di.api.AuthApiModule
import com.iyeongjoon.nicname.ddalivery.di.ui.activities.ActivityBinder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


// 의존성 컴포넌트
@Singleton
@Component(
    modules = arrayOf(
        AndroidSupportInjectionModule::class,
        ActivityBinder::class,
        NetworkModule::class,
        AuthApiModule::class
    )
)
interface AppComponent : AndroidInjector<DdaliveryApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(app: Context): Builder

        fun build(): AppComponent
    }
}