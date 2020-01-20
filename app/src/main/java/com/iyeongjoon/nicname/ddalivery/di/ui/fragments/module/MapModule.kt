package com.iyeongjoon.nicname.ddalivery.di.ui.fragments.module

import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.seller.SellerApi
import com.iyeongjoon.nicname.data.driver.DataDriver
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.map.MapViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MapModule{
    @Provides
    fun provideMapViewModelFactory(locationEvent: LocationEvent,dataDriver: DataDriver, sellerApi: SellerApi) = MapViewModelFactory(locationEvent,dataDriver,sellerApi)
}