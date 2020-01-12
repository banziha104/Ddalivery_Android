package com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules

import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signup.SignUpViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SignUpModule{
    @Provides
    fun provideSignUpViewModelFactory(authApi: AuthApi) = SignUpViewModelFactory(authApi)
}