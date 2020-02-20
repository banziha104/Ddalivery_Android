package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.map

import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.seller.SellerApi
import com.iyeongjoon.nicname.data.driver.DataDriver

class MapViewModel(
    val locationEvent: LocationEvent,
    val dataDriver: DataDriver,
    val sellerApi: SellerApi
) : ViewModel() {
    val locationObserver = locationEvent.getLocationObserver()
    val getSeller = sellerApi.seller()
}