package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home

import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.data.api.product.ProductApi
import com.iyeongjoon.nicname.domain.domain.product.Product
import io.reactivex.Observable

class HomeViewModel(val productApi: ProductApi) : ViewModel() {

    private val size = 100
    // 자동으로 페이지 증가
    private var page: Int = 0
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
//    get() {
//        return if (field == null || field.data.content.isEmpty()){
//            productApi
//                .product()
//                .getProducts(size, page++)
//                .blockingFirst()
//        }else{
//            val contents = productApi
//                .product()
//                .getProducts(size, page++)
//                .blockingFirst()
//            field.data.content.addAll(contents.data.content)
//            field
//        }
//    }

    val productObserver: Observable<Product> = productApi
        .product()
        .getProducts(size, page++)


}
