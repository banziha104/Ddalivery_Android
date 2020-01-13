package com.iyeongjoon.nicname.core.gps

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

@SuppressLint( "MissingPermission")
class LocationEvent(context: Context) : AnkoLogger{

    private val subject : PublishSubject<Location> = PublishSubject.create()
    private val locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    private val locationListener = object : LocationListener {
        override fun onLocationChanged(location: Location?) {
            if (location != null) subject.onNext(location)
        }

        override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        }

        override fun onProviderEnabled(provider: String?) {}

        override fun onProviderDisabled(provider: String?) {}
    }

    fun getLocationObserver() : Observable<Location>{
        info { "로케이션 get" }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1.0f, locationListener)
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1.0f, locationListener)
        return subject
    }

    fun stopUpdateLocation(){
        info { "로케이션 서비스 재개" }
        locationManager.removeUpdates(locationListener)
    }

    fun startUpdateLocation(){
        info { "로케이션 서비스 중지" }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1.0f, locationListener)
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1.0f, locationListener)
    }
}