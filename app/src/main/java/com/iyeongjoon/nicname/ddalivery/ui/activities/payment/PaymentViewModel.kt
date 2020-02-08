package com.iyeongjoon.nicname.ddalivery.ui.activities.payment

import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import com.iyeongjoon.nicname.domain.domain.db.entity.cart.CartEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PaymentViewModel(val localDatabase: LocalDatabase) : ViewModel() {
    val readCartData: Single<List<CartEntity>> = localDatabase
        .cartDao()
        .findAllToSingle()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
}