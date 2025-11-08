package com.example.sampleweatherapp.network

import com.example.sampleweatherapp.domain.WeatherResponse
import retrofit2.http.GET

interface ApiService {

    @GET("cxcsa")
    fun getForecast(): WeatherResponse

}