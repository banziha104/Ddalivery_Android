package com.iyeongjoon.nicname.data.`interface`

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface TestApi{
    @GET("park/")
    fun getPark(
        @Query("count") count : Int = 730
    ) : Observable<String>
}