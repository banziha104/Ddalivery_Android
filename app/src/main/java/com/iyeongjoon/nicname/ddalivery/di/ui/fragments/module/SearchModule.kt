package com.iyeongjoon.nicname.ddalivery.di.ui.fragments.module

import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.driver.DataDriver
import com.iyeongjoon.nicname.ddalivery.ui.fragments.main.search.SearchViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class SearchModule{
    @Provides
    fun provideSearchViewModelFactory(locationEvent: LocationEvent,dataDriver: DataDriver) = SearchViewModelFactory(locationEvent,dataDriver)
}