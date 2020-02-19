package com.iyeongjoon.nicname.data.db.dao

import androidx.room.*
import com.iyeongjoon.nicname.domain.domain.db.entity.token.TokenEntity
import io.reactivex.Observable
import io.reactivex.Single

@Dao
interface TokenDao {

    // Single 로 구현해도 되지만, zip 연산을위해 Observable로 변경
    @Query("SELECT * FROM token_store")
    fun findAll() : Observable<List<TokenEntity>>

    @Query("SELECT * FROM token_store")
    fun findAllToSingle() : Single<List<TokenEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity : TokenEntity)


    @Delete
    fun delete(entity : TokenEntity)

    @Update(onConflict =  OnConflictStrategy.REPLACE)
    fun update(entity : TokenEntity)
}