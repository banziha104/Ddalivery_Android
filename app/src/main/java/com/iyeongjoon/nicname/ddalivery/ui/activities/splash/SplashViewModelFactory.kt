package com.iyeongjoon.nicname.ddalivery.ui.activities.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase

class SplashViewModelFactory(val localDatabase: LocalDatabase,
                             val authApi: AuthApi,
                             val locationEvent: LocationEvent
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashViewModel(localDatabase,authApi,locationEvent) as T
    }
}