package com.iyeongjoon.nicname.ddalivery.ui.activities.splash

import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import io.reactivex.Observable
import io.reactivex.rxkotlin.Observables
import io.reactivex.schedulers.Schedulers

class SplashViewModel(
    val localDatabase: LocalDatabase,
    val authApi: AuthApi,
    val locationEvent: LocationEvent
) : ViewModel() {

    val getLocalData : Observable<SplashActivity.SplashDataType> = Observables.zip(
        localDatabase.tokenDao().findAll(),
        locationEvent.getLocationObserver()
    ) { t1, t2 -> SplashActivity.SplashDataType(t1, t2) }
        .subscribeOn(Schedulers.computation())
}