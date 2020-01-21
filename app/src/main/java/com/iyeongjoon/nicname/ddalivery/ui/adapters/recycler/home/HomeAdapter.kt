package com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.home

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.iyeongjoon.nicname.core.ex.plusAssign
import com.iyeongjoon.nicname.ddalivery.GlideApp
import com.iyeongjoon.nicname.ddalivery.R
import com.iyeongjoon.nicname.ddalivery.ex.imageUrl
import com.iyeongjoon.nicname.ddalivery.ui.dialogs.Item.ItemDialog
import com.iyeongjoon.nicname.ddalivery.ui.dialogs.Item.ItemDialogViewModel
import com.jakewharton.rxbinding3.view.clicks
import io.reactivex.android.schedulers.AndroidSchedulers


class HomeAdapter(val viewModel: HomeAdapterViewModel) :
    RecyclerView.Adapter<HomeAdapter.HomeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return HomeViewHolder(view)
    }

    override fun getItemCount(): Int = viewModel.length

    override fun onBindViewHolder(holder: HomeViewHolder, position: Int) {
        holder.apply {
            viewModel.let {
                val content = it.contents[position]

                title.text = content.productName

                container.layoutParams.width = it.layoutWidth

                viewModel.autoClearedDisposable += container
                    .clicks()
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe ({
                        viewModel.run {
                            val dialog = ItemDialog(ItemDialogViewModel(content,context,autoClearedDisposable,localDatabase))
                            dialog.window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
                            dialog.show()
                        }
                    },{
                        it.printStackTrace()
                    })
                GlideApp
                    .with(viewModel.context)
                    .load(content.image.imageUrl())
                    .into(img)
            }
        }
    }


    inner class HomeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val container = view.findViewById<ConstraintLayout>(R.id.homeContainer)
        val title = view.findViewById<TextView>(R.id.homeTxtTitle)
        val img = view.findViewById<ImageView>(R.id.homeImg)
    }
}