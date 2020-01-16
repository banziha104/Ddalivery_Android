package com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules

import com.iyeongjoon.nicname.ddalivery.ui.activities.payment.PaymentViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class PaymentModule{
    @Provides
    fun providePaymentViewModelFactory() = PaymentViewModelFactory()
}