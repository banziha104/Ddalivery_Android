package com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules

import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import com.iyeongjoon.nicname.ddalivery.ui.activities.payment.PaymentViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PaymentModule{
    @Provides
    fun providePaymentViewModelFactory(localDatabase: LocalDatabase) = PaymentViewModelFactory(localDatabase)
}