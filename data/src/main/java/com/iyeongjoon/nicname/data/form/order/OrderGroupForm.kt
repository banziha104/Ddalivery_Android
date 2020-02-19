package com.iyeongjoon.nicname.data.form.order

data class OrderGroupForm(
    val clientId : Int,
    val clientName : String,
    val address : String,
    val lat : Double,
    val long : Double,
    val orders : List<OrderForm>,
    var isMatched: Boolean = false,
    var isCompleted: Boolean = false
)