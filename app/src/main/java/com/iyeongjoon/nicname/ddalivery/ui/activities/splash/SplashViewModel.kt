package com.iyeongjoon.nicname.ddalivery.ui.activities.splash

import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase

class SplashViewModel(val localDatabase: LocalDatabase,
                      val authApi: AuthApi) : ViewModel(){

}