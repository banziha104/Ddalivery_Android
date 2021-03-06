package com.iyeongjoon.nicname.core.rx

import androidx.lifecycle.LifecycleObserver
import io.reactivex.disposables.Disposable

interface AutoClearedDisposableContract : LifecycleObserver{
    fun add(disposable: Disposable)
}