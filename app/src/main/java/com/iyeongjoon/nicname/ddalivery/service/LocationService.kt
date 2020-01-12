package com.iyeongjoon.nicname.ddalivery.service

import androidx.lifecycle.LifecycleService
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.core.rx.service.AutoClearedDisposable
import com.iyeongjoon.nicname.ddalivery.global.LifecycleDriver
import dagger.android.AndroidInjection
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import javax.inject.Inject

class LocationService : LifecycleService(), AnkoLogger {

    @Inject
    lateinit var locationEvent: LocationEvent
    private val disposables = AutoClearedDisposable(this)
    private val viewDisposables =
        AutoClearedDisposable(lifecycleOwner = this, alwaysClearOnStop = false)

    override fun onCreate() {
        super.onCreate()
        AndroidInjection.inject(this)
        info { "로케이션 이벤트 $locationEvent" }

        lifecycle += disposables
        lifecycle += viewDisposables
        disposables += LifecycleDriver.lifecycleDriver
            .subscribe {
                when (it) {
                    "ON_RESUME" -> locationEvent.startUpdateLocation()
                    "ON_STOP" -> locationEvent.stopUpdateLocation()
                }
            }
    }
}
