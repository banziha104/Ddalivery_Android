package com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signin

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import javax.inject.Named

class SignInViewModelFactory(
    val authApi: AuthApi,
    val localDatabase: LocalDatabase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignInViewModel(authApi,localDatabase) as T
    }
}