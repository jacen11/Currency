package com.pastukhov.currency.di


import com.pastukhov.currency.data.ApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


private val BASE_URL = "https://free.currconv.com/api/v7/convert/"

@Module
class RestModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .build()

    @Provides
    @Singleton
    fun provideCurrency(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}