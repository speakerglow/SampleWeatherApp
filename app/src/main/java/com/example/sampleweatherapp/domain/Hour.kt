package com.example.sampleweatherapp.domain

class Hour(
    val time_epoch: Long,
    val time: String,
    val temp_c: Double,
    val is_day: Int,
    val condition: Condition,
    val wind_kph: Double,
    val humidity: Int,
    val feelslike_c: Double
)