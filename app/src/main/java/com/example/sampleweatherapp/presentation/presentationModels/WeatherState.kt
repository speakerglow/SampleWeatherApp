package com.example.sampleweatherapp.presentation.presentationModels

import com.example.sampleweatherapp.domain.WeatherResponse

data class WeatherState(
    val isLoading: Boolean = false,
    val data: WeatherResponse? = null,
    val error: String? = null
)