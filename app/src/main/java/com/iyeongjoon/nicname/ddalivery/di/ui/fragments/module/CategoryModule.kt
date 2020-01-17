package com.iyeongjoon.nicname.ddalivery.di.ui.fragments.module

import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.category.CategoryApi
import com.iyeongjoon.nicname.data.driver.DataDriver
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.category.CategoryViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CategoryModule{
    @Provides
    fun provideCategoryViewModelFactory(locationEvent: LocationEvent,
                                        categoryApi: CategoryApi,
                                        dataDriver: DataDriver
    ) = CategoryViewModelFactory(locationEvent,categoryApi,dataDriver)
}