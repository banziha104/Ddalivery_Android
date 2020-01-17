package com.iyeongjoon.nicname.ddalivery.ui.adapters.recycler.category

import android.content.Context
import com.iyeongjoon.nicname.domain.domain.api.entity.category.Category

class CategoryAdapterViewModel( val context: Context,
                                val category: Category){
    val itemsize = category.data.size
    val items = category.data
}