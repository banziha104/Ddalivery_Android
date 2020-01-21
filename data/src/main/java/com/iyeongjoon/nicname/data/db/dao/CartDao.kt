package com.iyeongjoon.nicname.data.db.dao

import androidx.room.*
import com.iyeongjoon.nicname.domain.domain.db.entity.cart.CartEntity
import com.iyeongjoon.nicname.domain.domain.db.entity.token.TokenEntity
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface CartDao {

    // Single 로 구현해도 되지만, zip 연산을위해 Observable로 변경
    @Query("SELECT * FROM cart")
    fun findAll() : Observable<List<CartEntity>>

    @Query("SELECT * FROM cart")
    fun findAllToSingle() : Single<List<CartEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity : CartEntity)

    @Delete
    fun delete(entity : CartEntity)

    @Update(onConflict =  OnConflictStrategy.REPLACE)
    fun update(entity : CartEntity)
}