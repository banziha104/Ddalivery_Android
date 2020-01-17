package com.iyeongjoon.nicname.ddalivery.ui.fragments.main.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class CategoryViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CategoryViewModel() as T
    }
}