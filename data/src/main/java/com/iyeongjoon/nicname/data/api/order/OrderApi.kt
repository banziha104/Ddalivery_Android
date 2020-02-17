package com.iyeongjoon.nicname.data.api.order

import com.iyeongjoon.nicname.data.api.ApiBase
import com.iyeongjoon.nicname.data.api.product.ProductApiContract

class OrderApi : ApiBase(){
    fun product() = createApi(OrderApiContract::class.java)
}