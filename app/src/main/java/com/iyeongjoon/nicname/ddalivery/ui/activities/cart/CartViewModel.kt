package com.iyeongjoon.nicname.ddalivery.ui.activities.cart

import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.core.gps.LocationEvent
import com.iyeongjoon.nicname.data.api.order.OrderApi
import com.iyeongjoon.nicname.data.form.order.OrderForm
import com.iyeongjoon.nicname.data.form.order.OrderGroupForm
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import com.iyeongjoon.nicname.domain.domain.db.entity.cart.CartEntity
import com.iyeongjoon.nicname.domain.domain.db.entity.order.OrderEntity
import com.iyeongjoon.nicname.domain.domain.db.entity.token.TokenEntity
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class CartViewModel(val localDatabase: LocalDatabase,
                    private val orderApi: OrderApi,
                    val locationEvent: LocationEvent
) : ViewModel() {
    val readCartData: Single<List<CartEntity>> = localDatabase
        .cartDao()
        .findAllToSingle()
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())


    val loadToken : Single<List<TokenEntity>> = localDatabase
        .tokenDao()
        .findAllToSingle()
        .subscribeOn(Schedulers.io())

    fun orderCreate(orderGroupForm : OrderGroupForm) = orderApi
        .product()
        .createOrder(orderGroupForm)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())

    fun saveOrderGroup(orderGroupId : Int) = localDatabase.orderDao().insert(OrderEntity(null,orderGroupId))
}