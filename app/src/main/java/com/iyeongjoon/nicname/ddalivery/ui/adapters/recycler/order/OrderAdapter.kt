package com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.order

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.option.OptionAdapterViewModel

class OrderAdapter(val viewModel : OrderAdapterViewModel) : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_order,parent,false)
        return OrderViewHolder(view)
    }

    override fun getItemCount(): Int = viewModel.itemSize

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {

    }

    inner class OrderViewHolder(view : View) : RecyclerView.ViewHolder(view){

    }
}