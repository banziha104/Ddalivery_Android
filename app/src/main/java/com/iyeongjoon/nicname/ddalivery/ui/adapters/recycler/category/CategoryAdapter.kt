package com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.category

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.iyeongjoon.nicname.ddalivery.GlideApp
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ex.imageUrl


class CategoryAdapter(val viewModel: CategoryAdapterViewModel) : RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category,parent,false)
        return CategoryViewHolder(view)
    }

    override fun getItemCount(): Int = viewModel.itemsize

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        viewModel.items[position].let {
            holder.apply {
                title.text = it.categoryName

                GlideApp
                    .with(viewModel.context)
                    .load(it.image.imageUrl())
                    .into(img)
            }
        }
    }

    inner class CategoryViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val title = view.findViewById<TextView>(R.id.cgTxtTitle)
        val img = view.findViewById<ImageView>(R.id.cgImg)
    }
}