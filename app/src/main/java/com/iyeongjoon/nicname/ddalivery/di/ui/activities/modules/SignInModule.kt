package com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules

import android.content.Context
import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signin.SignInViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class SignInModule{

    @Provides
    fun provideSignInViewModelFactory(authApi: AuthApi) = SignInViewModelFactory(authApi)


}