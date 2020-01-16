package com.iyeongjoon.nicname.data.api.seller

import com.iyeongjoon.nicname.domain.domain.api.entity.seller.Seller
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface SellerApiContract{
    @GET("seller")
    fun findByDistance(@Query("latitude") latitude : Double,
                       @Query("longitude") longitude : Double,
                       @Query("limit") limit : Int) : Observable<Seller>
}