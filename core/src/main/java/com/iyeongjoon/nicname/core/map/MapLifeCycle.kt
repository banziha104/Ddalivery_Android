package com.iyeongjoon.nicname.core.map

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.google.android.gms.maps.MapView
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

class MapLifeCycle (
    lifecycleOwner: Fragment,
    private val map : MapView) : AnkoLogger, LifecycleObserver{

    init{
        lifecycleOwner.lifecycle.addObserver(this)
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(){
        map.onResume()
        info { "프래그먼트 : resume" }
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(){
        map.onPause()
        info { "프래그먼트 : pause" }
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(){
        map.onDestroy()

        info { "프래그먼트 : destroy" }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(){
        map.onStop()
        info { "프래그먼트 : stop" }
    }
}