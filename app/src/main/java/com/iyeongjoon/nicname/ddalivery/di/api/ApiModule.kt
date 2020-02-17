package com.iyeongjoon.nicname.ddalivery.di.api

import com.iyeongjoon.nicname.data.api.auth.AuthApi
import com.iyeongjoon.nicname.data.api.category.CategoryApi
import com.iyeongjoon.nicname.data.api.order.OrderApi
import com.iyeongjoon.nicname.data.api.product.ProductApi
import com.iyeongjoon.nicname.data.api.seller.SellerApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApiModule{
    @Provides
    @Singleton
    fun provideAuthApi() = AuthApi()

    @Provides
    @Singleton
    fun provideProductApi()  = ProductApi()

    @Provides
    @Singleton
    fun provideSellerApi()  = SellerApi()

    @Provides
    @Singleton
    fun provideCategoryApi()  = CategoryApi()

    @Provides
    @Singleton
    fun provideOrderApi()  = OrderApi()

}