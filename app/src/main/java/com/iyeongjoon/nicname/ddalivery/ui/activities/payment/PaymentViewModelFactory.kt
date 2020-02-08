package com.iyeongjoon.nicname.ddalivery.ui.activities.payment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase

class PaymentViewModelFactory(val localDatabase: LocalDatabase) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PaymentViewModel(localDatabase) as T
    }
}