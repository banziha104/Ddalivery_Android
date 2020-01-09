package com.iyeongjoon.nicname.domain.domain.product

data class Content(
    var category: Category,
    var description: String,
    var image: String,
    var price: Int,
    var productId: Int,
    var productName: String,
    var recommendedRateCount: Int,
    var recommendedUserCount: Int,
    var seller: Seller
)