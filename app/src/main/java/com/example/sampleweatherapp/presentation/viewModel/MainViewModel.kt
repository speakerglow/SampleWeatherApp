package com.example.sampleweatherapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.sampleweatherapp.data.Repository


class MainViewModel(
    private val repository: Repository
) : ViewModel(){

    fun foo(): String = repository.getForecast().toString()


}