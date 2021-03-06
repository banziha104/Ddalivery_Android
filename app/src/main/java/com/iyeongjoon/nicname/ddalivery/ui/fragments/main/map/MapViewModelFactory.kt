package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.map

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.seller.SellerApi
import com.iyeongjoon.nicname.data.driver.DataDriver

class MapViewModelFactory(
    val locationEvent: LocationEvent,
    val dataDriver: DataDriver,
    val sellerApi: SellerApi
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MapViewModel(locationEvent, dataDriver,sellerApi) as T
    }
}