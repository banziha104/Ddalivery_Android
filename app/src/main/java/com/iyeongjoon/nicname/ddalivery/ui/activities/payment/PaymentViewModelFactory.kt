package com.iyeongjoon.nicname.ddalivery.ui.activities.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class PaymentViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PaymentViewModel() as T
    }
}