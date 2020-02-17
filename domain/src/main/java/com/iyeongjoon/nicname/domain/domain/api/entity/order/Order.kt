package com.iyeongjoon.nicname.domain.domain.api.entity.order

data class Order(
    val categoryName: String,
    val description: String,
    val image: String,
    val orderId: Int,
    val price: Int,
    val productId: Int,
    val productName: String,
    val quantity: Int,
    val sellerAddress: String,
    val sellerName: String
)