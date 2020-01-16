package com.iyeongjoon.nicname.domain.domain.api.entity.product

data class Content(
    val category: Category,
    val description: String,
    val image: String,
    val price: Int,
    val productId: Int,
    val productName: String,
    val recommendedRateCount: Int,
    val recommendedUserCount: Int,
    val seller: Seller
)