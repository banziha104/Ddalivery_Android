package com.iyeongjoon.nicname.core.gps

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

class LocationBinder(private val lifecycleOwner: AppCompatActivity) : LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun startService(){
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun stopService(){

    }
}