package com.iyeongjoon.nicname.data.api.order

import com.iyeongjoon.nicname.data.form.order.OrderGroupForm
import com.iyeongjoon.nicname.domain.domain.api.entity.category.Category
import com.iyeongjoon.nicname.domain.domain.api.entity.order.OrderGroup
import com.iyeongjoon.nicname.domain.domain.base.ApiResponse
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface OrderApiContract{
    @GET("order/{orderGroupId}")
    fun findByOrderGroupId(
        @Path("orderGroupdId") orderGroupdId : Long
    ) : Observable<OrderGroup>

    @POST("order")
    fun createOrder(
        @Body orderGroupForm: OrderGroupForm
    ) : Observable<ApiResponse<*>>


}