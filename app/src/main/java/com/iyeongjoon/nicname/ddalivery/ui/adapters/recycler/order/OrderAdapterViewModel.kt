package com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.order

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.domain.domain.api.entity.order.OrderGroup


class OrderAdapterViewModel (val context : Context,
                             val orderGroup : OrderGroup){
    val itemSize : Int
    get() = orderGroup.data.size
}