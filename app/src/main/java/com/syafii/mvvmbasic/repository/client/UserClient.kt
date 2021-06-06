package com.syafii.mvvmbasic.repository.client

import com.google.gson.GsonBuilder
import com.syafii.mvvmbasic.BuildConfig.BASE_URL
import com.syafii.mvvmbasic.repository.services.LoginServices
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object UserClient {
    private val interceptor by lazy { HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY) }
    private val client by lazy { OkHttpClient.Builder().addInterceptor(interceptor).build() }

    private val gson by lazy { GsonConverterFactory.create(GsonBuilder().setLenient().create()) }
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gson)
            .client(client)
            .build()
    }

    val loginServices by lazy { retrofit.create(LoginServices::class.java) }
}