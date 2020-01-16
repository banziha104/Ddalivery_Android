package com.iyeongjoon.nicname.data.api.product

import com.iyeongjoon.nicname.domain.domain.base.ApiResponse
import com.iyeongjoon.nicname.domain.domain.api.entity.product.Data
import com.iyeongjoon.nicname.domain.domain.api.entity.product.Product
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface ProductApiContract {
    @GET("product/seller")
    fun getProductBySeller(
        @Query("size") size: Int,
        @Query("page") page: Int,
        @Query("seller") seller: Array<Long>
        ): Observable<Product>

    @GET("product/location")
    fun getProductsByLocation(
        @Query("size") size: Int,
        @Query("page") page: Int,
        @Query("latitude") latitude : Double,
        @Query("longitude") longitude : Double,
        @Query("limit") limit : Int
    ): Observable<Product>
}