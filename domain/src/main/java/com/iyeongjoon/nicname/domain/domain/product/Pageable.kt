package com.iyeongjoon.nicname.domain.domain.product

data class Pageable(
    var offset: Int,
    var pageNumber: Int,
    var pageSize: Int,
    var paged: Boolean,
    var sort: Sort,
    var unpaged: Boolean
)