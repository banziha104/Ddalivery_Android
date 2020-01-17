package com.iyeongjoon.nicname.data.api.seller

import com.iyeongjoon.nicname.data.api.ApiBase

class SellerApi : ApiBase(){
    fun seller() = createApi(SellerApi::class.java)
}