package com.example.sampleweatherapp.domain

class Current(
    val temp_c: Double,
    val condition: Condition,
    val wind_kph: Double,
    val humidity: Int,
    val feelslike_c: Double,
    val pressure_mb: Double,
    val precip_mm: Double,
    val vis_km: Double
)
