package com.idn.newsapp.data.network

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

object ApiClient {

        fun provideApiservice() : ApiServices {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor{
                    val newsRequest = it.request().newBuilder()
                        .addHeader("x-Api-Key", "0af09c3f63fd46a4bd8688f9be75e777")
                        .build()
                    it.proceed(newsRequest)
                }
                .readTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build()

            return Retrofit.Builder()
                .baseUrl("https://newsapi.org/")
                .client(okHttpClient)
                .addConverterFactory(MoshiConverterFactory.create())
                .build()
                .create(ApiServices::class.java)
        }
    }
