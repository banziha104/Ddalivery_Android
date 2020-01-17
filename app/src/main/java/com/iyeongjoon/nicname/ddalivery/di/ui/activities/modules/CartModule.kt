package com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules

import com.iyeongjoon.nicname.ddalivery.ui.activities.cart.CartViewModelFactory
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CartModule {
    @Provides
    fun provideCartViewModelFactory() = CartViewModelFactory()
}