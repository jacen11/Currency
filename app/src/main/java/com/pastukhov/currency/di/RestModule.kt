package com.pastukhov.currency.di

import com.google.gson.GsonBuilder
import com.pastukhov.currency.BuildConfig
import com.pastukhov.currency.data.ApiService
import com.pastukhov.currency.data.model.CurrencyModel
import com.pastukhov.currency.data.model.CurrencyModelDeserializer
import dagger.Module
import dagger.Provides
import okhttp3.HttpUrl
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BASIC
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import javax.inject.Singleton


private val BASE_URL = "https://free.currconv.com/"
private val API_KEY = "6bfeb100c4be1ee184fc"

@Module
class RestModule {

    private val gson = GsonBuilder()
        .setPrettyPrinting()
        .registerTypeAdapter(CurrencyModel::class.java, CurrencyModelDeserializer())
        .create()

    private fun getClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) BODY else BASIC
        val okHttp: OkHttpClient.Builder = OkHttpClient.Builder()
        okHttp.addInterceptor(logging)
        okHttp.addInterceptor(object : Interceptor {
            @Throws(IOException::class)
            override fun intercept(chain: Interceptor.Chain): Response {
                val original: Request = chain.request()
                val originalHttpUrl: HttpUrl = original.url
                val url = originalHttpUrl.newBuilder()
                    .addQueryParameter("apiKey", API_KEY)
                    .addQueryParameter("compact", "ultra")
                    .build()

                // Request customization: add request headers
                val requestBuilder: Request.Builder = original.newBuilder()
                    .url(url)
                val request: Request = requestBuilder.build()
                return chain.proceed(request)
            }
        })

        return okHttp.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(getClient())
        .build()

    @Provides
    @Singleton
    fun provideCurrency(retrofit: Retrofit): ApiService =
        retrofit.create(ApiService::class.java)
}
