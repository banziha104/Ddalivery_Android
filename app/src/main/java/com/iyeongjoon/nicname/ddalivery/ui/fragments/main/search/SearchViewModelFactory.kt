package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.driver.DataDriver

class SearchViewModelFactory(
    val locationEvent: LocationEvent,
    val dataDriver: DataDriver
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchViewModel(locationEvent,dataDriver) as T
    }
}