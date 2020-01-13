package com.iyeongjoon.nicname.core.rx.activity

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import androidx.appcompat.app.AppCompatActivity
import com.iyeongjoon.nicname.ddalivery.global.LifecycleDriver
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info

// 라이프사이클에맞게 해제되는 익스텐션
class AutoClearedDisposable(
    private val lifecycleOwner: AppCompatActivity,
    private val alwaysClearOnStop: Boolean = true,
    private val compositeDisposable: CompositeDisposable = CompositeDisposable()) : LifecycleObserver, AnkoLogger {


    fun add(disposable: Disposable) {
        LifecycleDriver.lifecycleDriver.onNext("ON_START")
        info { "라이프사이클 : 스타트" }
        check(lifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED))
        compositeDisposable.add(disposable)
    }


    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume(){
        info { "라이프사이클 : 재개" }
        LifecycleDriver.lifecycleDriver.onNext("ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun cleanUp() {
        info { "라이프사이클 : 스탑" }
        LifecycleDriver.lifecycleDriver.onNext("ON_STOP")
        if (!alwaysClearOnStop && !lifecycleOwner.isFinishing) {
            return
        }
        compositeDisposable.clear()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun detachSelf() {

        info { "라이프사이클 : 디스토이" }
        LifecycleDriver.lifecycleDriver.onNext("ON_DESTROY")
        compositeDisposable.clear()
        lifecycleOwner.lifecycle.removeObserver(this)
    }
}