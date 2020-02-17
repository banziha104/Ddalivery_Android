package com.iyeongjoon.nicname.domain.domain.api.entity.order

data class Data(
    val address: String,
    val clientName: String,
    val completed: Boolean,
    val lat: Double,
    val long: Double,
    val matched: Boolean,
    val orderGroupId: Int,
    val orders: List<Order>,
    val totalPrice: Int
)