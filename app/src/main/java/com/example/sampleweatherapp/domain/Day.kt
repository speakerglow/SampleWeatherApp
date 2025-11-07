package com.example.sampleweatherapp.domain

class Day(
    val maxtemp_c: Double,
    val mintemp_c: Double,
    val avgtemp_c: Double,
    val maxwind_kph: Double,
    val totalprecip_mm: Double,
    val condition: Condition
)
