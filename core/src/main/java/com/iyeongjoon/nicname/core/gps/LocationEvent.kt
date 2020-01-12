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

@SuppressLint( "MissingPermission")
class LocationEvent(context: Context) {

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
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1.0f, locationListener)
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1.0f, locationListener)
        return subject
    }

    fun stopUpdateLocation(){
        locationManager.removeUpdates(locationListener)
    }

    fun startUpdateLocation(){
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1.0f, locationListener)
        locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 1000, 1.0f, locationListener)
    }
}