package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.search

import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.driver.DataDriver

class SearchViewModel(val locationEvent: LocationEvent,
                      val dataDriver: DataDriver
) : ViewModel() {
}
