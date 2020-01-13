package com.iyeongjoon.nicname.domain.domain.db.entity.token

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "token_store")
data class TokenEntity(@PrimaryKey(autoGenerate = true) val id : Long,
                       var token : String)