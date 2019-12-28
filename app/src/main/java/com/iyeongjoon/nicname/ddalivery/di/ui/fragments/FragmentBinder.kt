package com.iyeongjoon.nicname.ddalivery.di.ui.fragments

import com.iyeongjoon.nicname.ddalivery.di.ui.fragments.module.CategoryModule
import com.iyeongjoon.nicname.ddalivery.di.ui.fragments.module.HomeModule
import com.iyeongjoon.nicname.ddalivery.di.ui.fragments.module.SearchModule
import com.iyeongjoon.nicname.ddalivery.di.ui.fragments.module.UserModule
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.category.CategoryFragment
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home.HomeFragment
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.search.SearchFragment
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.user.UserFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBinder{
    @ContributesAndroidInjector(modules = [HomeModule::class])
    abstract fun bindHomeModule() : HomeFragment

    @ContributesAndroidInjector(modules = [SearchModule::class])
    abstract fun bindSearchModule() : SearchFragment

    @ContributesAndroidInjector(modules = [UserModule::class])
    abstract fun bindUserModule() : UserFragment

    @ContributesAndroidInjector(modules = [CategoryModule::class])
    abstract fun bindCategoryModule() : CategoryFragment
}

