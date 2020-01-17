package com.iyeongjoon.nicname.domain.domain.api.entity.product

data class Seller(
    val image: String,
    val latitude: Double,
    val longitude: Double,
    val sellerId: Int,
    val sellerName: String
)