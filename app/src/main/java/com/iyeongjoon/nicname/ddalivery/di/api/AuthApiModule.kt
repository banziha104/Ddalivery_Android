package com.iyeongjoon.nicname.ddalivery.di.api

import com.iyeongjoon.nicname.data.api.auth.AuthApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AuthApiModule{
    @Provides
    @Singleton
    fun provideAuthApi() = AuthApi()
}