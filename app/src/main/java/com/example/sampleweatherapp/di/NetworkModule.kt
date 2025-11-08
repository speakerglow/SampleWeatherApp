package com.example.sampleweatherapp.di

import com.example.sampleweatherapp.network.ApiKeyInterceptor
import com.example.sampleweatherapp.network.ApiService
import okhttp3.OkHttpClient
import org.koin.dsl.module
import org.koin.dsl.single
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create()).client(get())
            .build()
    }
    single {
        get<Retrofit>().create(ApiService::class.java)
    }
    single {
        OkHttpClient.Builder()
            .addInterceptor(ApiKeyInterceptor(API_KEY))
            .build()
    }
}

private const val BASE_URL = "https://api.weatherapi.com/v1/"
private const val API_KEY = "fa8b3df74d4042b9aa7135114252304"
