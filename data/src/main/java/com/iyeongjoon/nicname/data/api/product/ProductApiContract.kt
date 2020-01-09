package com.iyeongjoon.nicname.data.api.product

import com.iyeongjoon.nicname.domain.domain.base.ApiResponse
import com.iyeongjoon.nicname.domain.domain.product.Data
import com.iyeongjoon.nicname.domain.domain.product.Product
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ProductApiContract{
    @GET("product")
    fun getProducts(@Query("size") size :Int,
                    @Query("page") page : Int) : Observable<Product>
}