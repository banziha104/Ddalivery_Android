package com.iyeongjoon.nicname.data.api

import com.iyeongjoon.nicname.data.constants.BASE_URL
import com.iyeongjoon.nicname.data.modules.NetworkModule
import retrofit2.Retrofit

open class ApiBase{
    val networkModule = NetworkModule()

    fun <T> createApi(api : Class<T>) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(networkModule.provideOkHttpClient())
            .addCallAdapterFactory(networkModule.provideCallAdapterFactory())
            .addConverterFactory(networkModule.provideConverterFactory())
            .build()
            .create(api)
}