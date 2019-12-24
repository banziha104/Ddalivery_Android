package com.iyeongjoon.nicname.data.api.auth

import com.iyeongjoon.nicname.domain.TestModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface AuthApiContract{
    @GET("product")
    fun getTest() : Observable<TestModel>
}