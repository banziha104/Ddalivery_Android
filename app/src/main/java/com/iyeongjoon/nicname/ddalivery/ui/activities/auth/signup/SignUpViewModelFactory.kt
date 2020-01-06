package com.iyeongjoon.nicname.ddalivery.ui.activities.auth.signup

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.data.api.auth.AuthApi

class SignUpViewModelFactory(val authApi: AuthApi) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SignUpViewModel(authApi) as T
    }
}