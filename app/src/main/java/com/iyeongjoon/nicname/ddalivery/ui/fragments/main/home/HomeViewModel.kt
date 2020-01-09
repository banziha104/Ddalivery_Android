package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home

import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.data.api.product.ProductApi
import com.iyeongjoon.nicname.domain.domain.product.Product

class HomeViewModel(val productApi: ProductApi) : ViewModel() {

    private val size = 100
    private var page = 0
    
    private val product : Product by lazy {
        productApi
            .product()
            .getProducts(size, page++)
            .blockingFirst()
    }


    fun refreshData(){

    }

}
