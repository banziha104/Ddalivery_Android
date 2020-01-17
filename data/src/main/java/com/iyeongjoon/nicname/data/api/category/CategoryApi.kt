package com.iyeongjoon.nicname.data.api.category

import com.iyeongjoon.nicname.data.api.ApiBase

class CategoryApi : ApiBase() {
    fun category() = createApi(CategoryApiContract::class.java)
}