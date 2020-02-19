package com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules

import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.order.OrderApi
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import com.iyeongjoon.nicname.ddalivery.ui.activities.cart.CartViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CartModule {
    @Provides
    fun provideCartViewModelFactory(localDatabase : LocalDatabase,
                                    orderApi: OrderApi,
                                    locationEvent: LocationEvent) = CartViewModelFactory(localDatabase,orderApi,locationEvent)
}