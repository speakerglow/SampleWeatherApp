package com.example.sampleweatherapp.data

import com.example.sampleweatherapp.domain.WeatherResponse
import com.example.sampleweatherapp.data.ApiService

class Repository(private val apiService: ApiService) {

    suspend fun getForecast(location: String, days: Int): WeatherResponse {
        return apiService.getForecast(location = location, days = days)
    }
}