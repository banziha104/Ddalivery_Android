package com.iyeongjoon.nicname.ddalivery.di.ui.activities

import com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules.*
import com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signin.SignInActivity
import com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signup.SignUpActivity
import com.iyeongjoon.nicname.ddalivery.ui.activities.cart.CartActivity
import com.iyeongjoon.nicname.ddalivery.ui.activities.main.MainActivity
import com.iyeongjoon.nicname.ddalivery.ui.activities.splash.SplashActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder{

    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun bindMainModule() : MainActivity

    @ContributesAndroidInjector(modules = [SignInModule::class])
    abstract fun bindSignInModule() : SignInActivity

    @ContributesAndroidInjector(modules = [SignUpModule::class])
    abstract fun bindSignUpModule() : SignUpActivity

    @ContributesAndroidInjector(modules = [SplashModule::class])
    abstract fun bindSplashModule() : SplashActivity

    @ContributesAndroidInjector(modules = [CartModule::class])
    abstract fun bindCartModule() : CartActivity
}