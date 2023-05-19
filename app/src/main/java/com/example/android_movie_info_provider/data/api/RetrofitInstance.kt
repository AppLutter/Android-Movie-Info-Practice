package com.example.android_movie_info_provider.data.api

import com.example.android_movie_info_provider.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {

    private val okHttpClient: OkHttpClient by lazy {
        val httpLoggingInterceptor =
            HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

        OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build()
    }


    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().client(okHttpClient).baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create()).build()
    }
    val movieApi: MovieApi by lazy {
        retrofit.create(MovieApi::class.java)
    }
}