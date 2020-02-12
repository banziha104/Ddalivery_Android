package com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.cart

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.ddalivery.GlideApp
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ex.imageUrl
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.runOnUiThread


class CartAdapter(val viewModel: CartAdapterViewModel) :
    RecyclerView.Adapter<CartAdapter.CartViewHolder>(), AnkoLogger {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return CartViewHolder(view)
    }

    override fun getItemCount(): Int = viewModel.itemSize

    override fun onBindViewHolder(holder: CartViewHolder, position: Int) {
        holder.run {
            viewModel.data[position].let {
                title.text = it.productName
                price.text = it.price.toString()
                quantity.text = it.quantity.toString()

                viewModel.disposable += btnCancel
                    .clicks()
                    .observeOn(Schedulers.io())
                    .subscribe({ _ ->
                        viewModel.database.cartDao().delete(it)
                        viewModel.data.remove(it)
                        viewModel.context.runOnUiThread {
                            notifyDataSetChanged()
                        }
                    }, {
                        it.printStackTrace()
                    })

                GlideApp
                    .with(viewModel.context)
                    .load(it.image.imageUrl())
                    .into(img)
            }
        }
    }

    inner class CartViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.itemCartTxtTitle)
        val price = view.findViewById<TextView>(R.id.itemCartTxtPrice)
        val quantity = view.findViewById<TextView>(R.id.itemCartTxtQuantity)
        val img = view.findViewById<ImageView>(R.id.itemCartImg)
        val btnCancel = view.findViewById<Button>(R.id.itemCartBtnCancel)
    }
}