package com.iyeongjoon.nicname.data.db.dao

import androidx.room.*
import com.iyeongjoon.nicname.domain.domain.db.entity.cart.CartEntity
import com.iyeongjoon.nicname.domain.domain.db.entity.order.OrderEntity
import io.reactivex.Observable
import io.reactivex.Single


@Dao
interface OrderDao {

    @Query("SELECT * FROM order_table")
    fun findAll() : Observable<List<OrderEntity>>

    @Query("SELECT * FROM order_table")
    fun findAllToSingle() : Single<List<OrderEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity : OrderEntity)

    @Update(onConflict =  OnConflictStrategy.REPLACE)
    fun update(entity : OrderEntity)

    @Delete
    fun delete(entity : OrderEntity)

    @Query("DELETE FROM order_table")
    fun deleteAll()
}