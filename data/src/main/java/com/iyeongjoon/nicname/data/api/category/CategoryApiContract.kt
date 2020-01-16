package com.iyeongjoon.nicname.data.api.category

import com.iyeongjoon.nicname.domain.domain.api.entity.category.Category
import io.reactivex.Observable
import retrofit2.http.GET

interface CategoryApiContract{
    @GET("category")
    fun findAll() : Observable<Category>
}