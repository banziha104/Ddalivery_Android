package com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signin

import androidx.lifecycle.ViewModel
import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.data.api.auth.AuthApiContract
import com.iyeongjoon.nicname.data.db.dao.TokenDao
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import com.iyeongjoon.nicname.domain.domain.db.entity.token.TokenEntity
import io.reactivex.Single
import org.jetbrains.anko.AnkoLogger

class SignInViewModel(
    val authApi: AuthApi,
    val localDatabase: LocalDatabase
) : ViewModel(), AnkoLogger {

    val auth: AuthApiContract = authApi
        .auth()

    val singleTokenStore: Single<List<TokenEntity>> = localDatabase
        .tokenDao()
        .findAllToSingle()
}