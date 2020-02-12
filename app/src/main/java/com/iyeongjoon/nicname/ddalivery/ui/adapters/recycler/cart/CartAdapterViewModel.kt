package com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.cart

import android.content.Context
import com.iyeongjoon.nicname.core.rx.activity.AutoClearedDisposable
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import com.iyeongjoon.nicname.domain.domain.db.entity.cart.CartEntity

class CartAdapterViewModel(val context: Context,
                           val data: ArrayList<CartEntity>,
                           val disposable: AutoClearedDisposable,
                           val database : LocalDatabase
){
    var itemSize: Int = 0
    get() = data.size
}