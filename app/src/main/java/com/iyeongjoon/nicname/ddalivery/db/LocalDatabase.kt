package com.iyeongjoon.nicname.ddalivery.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.iyeongjoon.nicname.data.db.dao.CartDao
import com.iyeongjoon.nicname.data.db.dao.TokenDao
import com.iyeongjoon.nicname.domain.domain.db.entity.cart.CartEntity
import com.iyeongjoon.nicname.domain.domain.db.entity.token.TokenEntity

@Database(
    entities = [TokenEntity::class, CartEntity::class],
    version = 2,
    exportSchema = false
)
abstract class LocalDatabase : RoomDatabase() {
    abstract fun tokenDao(): TokenDao
    abstract fun cartDao(): CartDao
}