package com.iyeongjoon.nicname.data.form.order

data class OrderGroupForm(
    val clientName : String,
    val address : String,
    val lat : Double,
    val long : Double,
    val totalPrice : Int,
    var isMatched: Boolean,
    var isCompleted: Boolean,
    val orders : List<OrderForm>
)