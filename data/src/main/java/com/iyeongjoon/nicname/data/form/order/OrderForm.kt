package com.iyeongjoon.nicname.data.form.order

data class OrderForm(
    val productId : Long,
    val productName: String,
    val image: String,
    val description: String,
    val price: Int,
    val quantity : Int
)