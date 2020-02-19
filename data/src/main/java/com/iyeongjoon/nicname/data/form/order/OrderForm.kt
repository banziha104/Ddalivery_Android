package com.iyeongjoon.nicname.data.form.order

import com.iyeongjoon.nicname.domain.domain.db.entity.cart.CartEntity

data class OrderForm(
    val productId : Int,
    val productName: String,
    val image: String,
    val description: String,
    val price: Int,
    val quantity : Int
){
    companion object{
        fun from(cart : CartEntity) : OrderForm = cart.run { OrderForm(productId,productName, image, description, price, quantity) }
    }
}