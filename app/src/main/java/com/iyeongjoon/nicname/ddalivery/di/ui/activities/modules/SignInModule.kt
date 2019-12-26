package com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules

import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signin.SignInViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SignInModule{

    @Provides
    fun provideSignInViewModelFactory(authApi: AuthApi) = SignInViewModelFactory(authApi)


}