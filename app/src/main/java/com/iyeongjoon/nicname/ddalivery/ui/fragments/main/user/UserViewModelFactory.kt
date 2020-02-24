package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.user

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase

class UserViewModelFactory(val localDatabase: LocalDatabase) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserViewModel(localDatabase) as T
    }
}