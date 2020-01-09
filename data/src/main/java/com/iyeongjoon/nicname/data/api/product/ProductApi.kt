package com.iyeongjoon.nicname.data.api.product

import com.iyeongjoon.nicname.data.api.ApiBase


class ProductApi : ApiBase(){
    fun product() = createApi(ProductApiContract::class.java)
}