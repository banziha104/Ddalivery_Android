package com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.cart

import android.content.Context
import com.iyeongjoon.nicname.domain.domain.api.entity.category.Category
import com.iyeongjoon.nicname.domain.domain.db.entity.cart.CartEntity

class CartAdapterViewModel(val context: Context,
                           val data: List<CartEntity>
){
    val itemsize = data.size
}