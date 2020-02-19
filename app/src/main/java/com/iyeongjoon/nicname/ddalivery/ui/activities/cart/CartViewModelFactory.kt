package com.iyeongjoon.nicname.ddalivery.ui.activities.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.order.OrderApi
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase

class CartViewModelFactory(val localDatabase : LocalDatabase,
                           val orderApi: OrderApi,
                           val locationEvent: LocationEvent
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CartViewModel(localDatabase,orderApi,locationEvent) as T
    }
}