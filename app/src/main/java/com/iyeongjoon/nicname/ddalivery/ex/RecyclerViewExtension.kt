package com.iyeongjoon.nicname.ddalivery.ex

import android.widget.AbsListView
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

// 스크롤 끝 감지
fun RecyclerView.endScrollEvent() : Observable<Boolean>{
    val subject = PublishSubject.create<Boolean>()
    this.addOnScrollListener(object: RecyclerView.OnScrollListener() {
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if (!recyclerView.canScrollVertically(1)){
                subject.onNext(true)
            }
        }
    })
    return subject
}