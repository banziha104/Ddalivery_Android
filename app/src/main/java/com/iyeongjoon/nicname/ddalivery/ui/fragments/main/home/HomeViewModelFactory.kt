package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomeViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeViewModel() as T
    }
}