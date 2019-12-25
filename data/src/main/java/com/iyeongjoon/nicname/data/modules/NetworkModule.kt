package com.iyeongjoon.nicname.data.modules

import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


// Api 관련 의존성주입 모듈
class NetworkModule{

    // Rxjava 팩토리
    fun provideCallAdapterFactory(): CallAdapter.Factory // RxConvererter
            = RxJava2CallAdapterFactory.createAsync()

    // gson 파서팩토리
    fun provideConverterFactory(): Converter.Factory // GsonFactory
            = GsonConverterFactory.create()

    // okhttp 팩토리
    fun provideOkHttpClient() : OkHttpClient
            = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .build()
}