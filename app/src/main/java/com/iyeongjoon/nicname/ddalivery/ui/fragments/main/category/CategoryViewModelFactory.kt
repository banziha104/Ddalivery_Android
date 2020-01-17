package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.category.CategoryApi
import com.iyeongjoon.nicname.data.driver.DataDriver

class CategoryViewModelFactory(
    val locationEvent: LocationEvent,
    val categoryApi: CategoryApi,
    val dataDriver: DataDriver
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CategoryViewModel(locationEvent, categoryApi,dataDriver) as T
    }
}