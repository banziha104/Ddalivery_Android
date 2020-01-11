package com.iyeongjoon.nicname.core.ex

import io.reactivex.Completable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

// 자동 제거 등록
operator fun com.iyeongjoon.nicname.core.rx.activity.AutoClearedDisposable.plusAssign(disposable: Disposable)
        = this.add(disposable)

operator fun com.iyeongjoon.nicname.core.rx.fragment.AutoClearedDisposable.plusAssign(disposable: Disposable)
        = this.add(disposable)
fun runOnIoScheduler(func: () -> Unit): Disposable
        = Completable.fromCallable(func).subscribeOn(Schedulers.io()).subscribe()
