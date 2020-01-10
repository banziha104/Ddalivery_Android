package com.iyeongjoon.nicname.ddalivery.di.api

import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.data.api.product.ProductApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ProductApiModule{
    @Provides
    @Singleton
    fun provideProductApi()  = ProductApi()
}