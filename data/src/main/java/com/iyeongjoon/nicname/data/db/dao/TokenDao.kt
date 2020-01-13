package com.iyeongjoon.nicname.data.db.dao

import androidx.room.*
import com.iyeongjoon.nicname.domain.domain.db.entity.token.TokenEntity
import io.reactivex.Single

@Dao
interface TokenDao {
    @Query("SELECT * FROM token_store")
    fun findAll() : Single<List<TokenEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(entity : TokenEntity)


    @Delete
    fun delete(entity : TokenEntity)

    @Update(onConflict =  OnConflictStrategy.IGNORE)
    fun update(entity : TokenEntity)
}