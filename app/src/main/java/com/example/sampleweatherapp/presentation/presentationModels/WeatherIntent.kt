package com.example.sampleweatherapp.presentation.presentationModels

sealed class WeatherIntent {
    class LoadForecast() : WeatherIntent()
}