package com.iyeongjoon.nicname.ddalivery.di.ui.fragments.module

import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.product.ProductApi
import com.iyeongjoon.nicname.data.driver.DataDriver
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home.HomeViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class HomeModule {
    @Provides
    fun provideHomeViewModelFactory(
        productApi: ProductApi,
        locationEvent: LocationEvent,
        dataDriver: DataDriver
    ) = HomeViewModelFactory(productApi, locationEvent,dataDriver)
}