package com.example.sampleweatherapp.data

import com.example.sampleweatherapp.network.ApiService
import javax.inject.Inject

class Repository @Inject constructor(
    private val apiService: ApiService
) {

    fun getForecast(): Boolean {
        return true
    }

}