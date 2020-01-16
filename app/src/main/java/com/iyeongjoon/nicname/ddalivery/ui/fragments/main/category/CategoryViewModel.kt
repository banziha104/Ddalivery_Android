package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.category

import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.category.CategoryApi
import com.iyeongjoon.nicname.data.driver.DataDriver

class CategoryViewModel(
    val locationEvent: LocationEvent,
    val categoryApi: CategoryApi,
    val dataDriver: DataDriver
) : ViewModel() {

}
