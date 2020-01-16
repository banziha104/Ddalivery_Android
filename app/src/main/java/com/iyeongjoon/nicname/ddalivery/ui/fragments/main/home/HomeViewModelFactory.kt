package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.product.ProductApi
import com.iyeongjoon.nicname.data.driver.DataDriver

class HomeViewModelFactory(val productApi: ProductApi,
                           val locationEvent: LocationEvent,
                           val dataDriver: DataDriver
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(productApi,locationEvent,dataDriver) as T
    }
}