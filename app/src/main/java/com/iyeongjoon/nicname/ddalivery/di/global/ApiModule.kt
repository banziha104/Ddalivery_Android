package com.jiwoo.choi.nanumcar.di.global

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module
class ApiModule{
//    @Provides
//    @Singleton
//    fun provideNoticeModel(rxAdapter: CallAdapter.Factory,
//                            @Named("gson")gsonConverter: Converter.Factory,
//                            client: OkHttpClient)
//            = Retrofit.Builder()
//            .baseUrl(SERVER_URL)
//            .client(client)
//            .addCallAdapterFactory(rxAdapter)
//            .addConverterFactory(gsonConverter)
//            .build()
//            .create(NoticeApi::class.java)

}