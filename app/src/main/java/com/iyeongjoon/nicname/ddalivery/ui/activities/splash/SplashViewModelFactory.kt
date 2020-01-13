package com.iyeongjoon.nicname.ddalivery.ui.activities.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase

class SplashViewModelFactory(val localDatabase: LocalDatabase,
                             val authApi: AuthApi
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashViewModel(localDatabase,authApi) as T
    }
}