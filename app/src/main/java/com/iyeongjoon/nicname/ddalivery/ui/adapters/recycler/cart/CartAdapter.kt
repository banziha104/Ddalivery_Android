package com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iyeongjoon.nicname.ddalivery.GlideApp
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ex.imageUrl


class CartAdapter(val viewModel: CartAdapterViewModel) : RecyclerView.Adapter<CartAdapter.CartViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart,parent,false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int = viewModel.itemsize

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.run {
            viewModel.data[position].let {
                title.text = it.quantity.toString()
                GlideApp
                    .with(viewModel.context)
                    .load(it.image.imageUrl())
                    .into(img)
            }
        }
    }

    inner class CartViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.itemCartTxtTitle)
        val img = view.findViewById<ImageView>(R.id.itemCartImg)
    }
}