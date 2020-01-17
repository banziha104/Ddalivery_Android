package com.iyeongjoon.nicname.ddalivery.ui.activities.cart

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CartViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CartViewModel() as T
    }
}