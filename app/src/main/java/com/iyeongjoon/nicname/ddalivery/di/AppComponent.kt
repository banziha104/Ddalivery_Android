package com.iyeongjoon.nicname.ddalivery.di

import android.content.Context
import com.iyeongjoon.nicname.ddalivery.DdaliveryApplication
import com.iyeongjoon.nicname.ddalivery.di.api.ApiModule
import com.iyeongjoon.nicname.ddalivery.di.global.*
import com.iyeongjoon.nicname.ddalivery.di.ui.activities.ActivityBinder
import com.iyeongjoon.nicname.ddalivery.di.ui.fragments.FragmentBinder
import com.iyeongjoon.nicname.ddalivery.di.ui.service.ServiceBinder
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


// 의존성 컴포넌트
@Singleton
@Component(
    modules = [AndroidSupportInjectionModule::class,
        ActivityBinder::class,
        FragmentBinder::class,
        ServiceBinder::class,
        NetworkModule::class,
        ApiModule::class,
        LocationModule::class,
        LocalDatabaseModule::class,
        DriverModule::class,
        AppModule::class]
)
interface AppComponent : AndroidInjector<DdaliveryApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(context : Context): Builder

        fun build(): AppComponent
    }
}