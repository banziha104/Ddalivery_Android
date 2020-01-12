package com.iyeongjoon.nicname.core.rx.activity

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.OnLifecycleEvent
import com.iyeongjoon.nicname.ddalivery.global.LifecycleDriver
import io.reactivex.disposables.Disposable

// 라이프사이클 오너에 등록하는 익스텐션
class AutoActivatedDisposable(
        private val lifecycleOwner: LifecycleOwner,
        private val func: () -> Disposable)
    : LifecycleObserver {

    private var disposable: Disposable? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun activate() {
        LifecycleDriver.lifecycleDriver.onNext("ON_START")
        disposable = func.invoke()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun resume(){
        LifecycleDriver.lifecycleDriver.onNext("ON_RESUME")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun deactivate() {
        LifecycleDriver.lifecycleDriver.onNext("ON_STOP")
        disposable?.dispose()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun detachSelf() {
        LifecycleDriver.lifecycleDriver.onNext("ON_DESTROY")
        lifecycleOwner.lifecycle.removeObserver(this)
    }
}
