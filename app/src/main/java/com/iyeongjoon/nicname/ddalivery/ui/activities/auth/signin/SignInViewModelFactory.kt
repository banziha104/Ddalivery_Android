package com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signin

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.data.api.auth.AuthApi
import javax.inject.Named

class SignInViewModelFactory(val authApi: AuthApi
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignInViewModel(authApi) as T
    }
}