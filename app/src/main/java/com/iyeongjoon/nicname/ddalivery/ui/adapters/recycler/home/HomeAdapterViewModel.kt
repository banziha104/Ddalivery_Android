package com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.home

import android.content.Context
import com.iyeongjoon.nicname.core.rx.fragment.AutoClearedDisposable
import com.iyeongjoon.nicname.domain.domain.api.entity.product.Product
import org.jetbrains.anko.displayMetrics

class HomeAdapterViewModel(product : Product, val context : Context, val autoClearedDisposable: AutoClearedDisposable){
    var length = product.data.content.size
    var contents = product.data.content
    var layoutWidth = (context.displayMetrics.widthPixels / 2)
}