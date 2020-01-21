package com.iyeongjoon.nicname.domain.domain.db.entity.cart

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartEntity(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val categoryName: String,
    val description: String,
    val image: String,
    val price: Int,
    val productId: Int,
    val productName: String,
    val quantity : Int
)