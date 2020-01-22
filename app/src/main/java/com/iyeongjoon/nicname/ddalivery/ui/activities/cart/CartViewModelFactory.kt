package com.iyeongjoon.nicname.ddalivery.ui.activities.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase

class CartViewModelFactory(val localDatabase : LocalDatabase) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CartViewModel(localDatabase) as T
    }
}