package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.iyeongjoon.nicname.data.api.product.ProductApi
import com.iyeongjoon.nicname.domain.domain.product.Product
import io.reactivex.Observable
import org.jetbrains.anko.AnkoLogger

class HomeViewModel(val productApi: ProductApi) : ViewModel(), AnkoLogger {

    // 요청
    val gridColumns = 2
    private val size = 100
    // 호출될때마다 자동으로 페이지 증가, 0 부터 시작해야함으로 -1로 초기화
    private var page: Int = -1
        get() = field++


    var productModel: Product? = null
        set(value) {
            if (value != null) {
                field?.let {
                    it.data.content.addAll(value.data.content)
                }.let {
                    field = value
                }
            }
        }

    var changedDataStartPoint = size * page

    fun productObserver(): Observable<Product> = productApi
        .product()
        .getProducts(size, page)

}
