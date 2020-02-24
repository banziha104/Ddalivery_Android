package com.iyeongjoon.nicname.domain.domain.db.entity.order

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "order_table")
data class OrderEntity(
    @PrimaryKey(autoGenerate = true) val id: Long?,
    val orderGroupId : Int
)