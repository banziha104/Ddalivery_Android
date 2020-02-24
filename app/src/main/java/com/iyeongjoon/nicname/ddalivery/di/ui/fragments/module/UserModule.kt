package com.iyeongjoon.nicname.ddalivery.di.ui.fragments.module

import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.user.UserViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class UserModule{
    @Provides
    fun provideUserViewModelFactory(localDatabase: LocalDatabase) = UserViewModelFactory(localDatabase)
}