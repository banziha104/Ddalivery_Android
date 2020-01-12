package com.iyeongjoon.nicname.ddalivery.global

import io.reactivex.subjects.PublishSubject

object LifecycleDriver {
    val lifecycleDriver: PublishSubject<String> = PublishSubject.create<String>()
}