package com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules

import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import com.iyeongjoon.nicname.ddalivery.ui.activities.splash.SplashViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SplashModule{
    @Provides
    fun provideSplashViewModelFactory(localDatabase: LocalDatabase,
                                      locationEvent: LocationEvent,
                                      authApi: AuthApi) = SplashViewModelFactory(localDatabase,authApi,locationEvent)
}