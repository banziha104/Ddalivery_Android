package com.iyeongjoon.nicname.ddalivery.di.ui.fragments.module

import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.category.CategoryViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CategoryModule{
    @Provides
    fun provideCategoryViewModelFactory() = CategoryViewModelFactory()
}