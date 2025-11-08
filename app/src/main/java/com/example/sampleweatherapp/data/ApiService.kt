package com.example.sampleweatherapp.data

import com.example.sampleweatherapp.domain.WeatherResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("forecast.json")
    suspend fun getForecast(
        @Query("q") location: String,
        @Query("days") days: Int
    ): WeatherResponse

}