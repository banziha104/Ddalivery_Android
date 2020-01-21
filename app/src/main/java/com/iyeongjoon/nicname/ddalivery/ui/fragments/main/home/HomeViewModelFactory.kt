package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.product.ProductApi
import com.iyeongjoon.nicname.data.driver.DataDriver
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase

class HomeViewModelFactory(val productApi: ProductApi,
                           val locationEvent: LocationEvent,
                           val dataDriver: DataDriver,
                           val localDatabase: LocalDatabase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(productApi,locationEvent,dataDriver,localDatabase) as T
    }
}