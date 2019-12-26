package com.iyeongjoon.nicname.ddalivery.di.ui.activities

import com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules.MainModule
import com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules.SignInModule
import com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules.SignUpModule
import com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signin.SignInActivity
import com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signup.SignUpActivity
import com.iyeongjoon.nicname.ddalivery.ui.activities.main.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBinder{

    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindMainModule() : MainActivity

    @ContributesAndroidInjector(modules = arrayOf(SignInModule::class))
    abstract fun bindSignInModule() : SignInActivity

    @ContributesAndroidInjector(modules = arrayOf(SignUpModule::class))
    abstract fun bindSignUpModule() : SignUpActivity
}