package com.iyeongjoon.nicname.ddalivery.di.ui.activities.modules

import com.iyeongjoon.nicname.ddalivery.db.LocalDatabase
import com.iyeongjoon.nicname.ddalivery.ui.activities.cart.CartViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CartModule {
    @Provides
    fun provideCartViewModelFactory(localDatabase : LocalDatabase) = CartViewModelFactory(localDatabase)
}