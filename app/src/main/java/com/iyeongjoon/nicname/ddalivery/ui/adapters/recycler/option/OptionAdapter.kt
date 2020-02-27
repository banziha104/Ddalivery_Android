package com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.option

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.iyeongjoon.nicname.ddalivery.R


class OptionAdapter(val viewModel : OptionAdapterViewModel) : RecyclerView.Adapter<OptionAdapter.OptionViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_option,parent,false)
        return OptionViewHolder(view)
    }

    override fun getItemCount(): Int = viewModel.size

    override fun onBindViewHolder(holder: OptionViewHolder, position: Int) {

    }

    inner class OptionViewHolder(view : View) : RecyclerView.ViewHolder(view){
        
    }
}