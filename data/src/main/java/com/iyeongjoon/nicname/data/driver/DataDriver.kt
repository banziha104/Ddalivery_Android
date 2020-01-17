package com.iyeongjoon.nicname.data.driver

import com.iyeongjoon.nicname.domain.domain.api.entity.category.Category
import com.iyeongjoon.nicname.domain.domain.api.entity.product.Product
import com.iyeongjoon.nicname.domain.domain.api.entity.product.Seller
import io.reactivex.subjects.BehaviorSubject

data class DataDriver(
    val category : BehaviorSubject<Category> = BehaviorSubject.create(),
    val product : BehaviorSubject<Product> = BehaviorSubject.create(),
    val seller : BehaviorSubject<Seller> = BehaviorSubject.create()
)