package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.data.api.product.ProductApi

class HomeViewModelFactory(private val productApi: ProductApi) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel(productApi) as T
    }
}