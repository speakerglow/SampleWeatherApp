package com.example.sampleweatherapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleweatherapp.data.Repository
import com.example.sampleweatherapp.presentation.presentationModels.WeatherIntent
import com.example.sampleweatherapp.presentation.presentationModels.WeatherState
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class MainViewModel(
    private val repository: Repository
) : ViewModel() {

    private val intentChannel = Channel<WeatherIntent>(Channel.UNLIMITED)

    private val _state = MutableStateFlow(WeatherState())
    val state: StateFlow<WeatherState> = _state.asStateFlow()

    init {
        handleIntents()
    }

    fun sendIntent(intent: WeatherIntent) {
        viewModelScope.launch {
            intentChannel.send(intent)
        }
    }

    private fun handleIntents() {
        viewModelScope.launch {
            for (intent in intentChannel) {
                when (intent) {
                    is WeatherIntent.LoadForecast -> loadForecast()
                }
            }
        }
    }

    private suspend fun loadForecast(location: String = LOCATION, days: Int = DAYS) {
        _state.value = WeatherState(isLoading = true)
        try {
            val forecast = repository.getForecast(
                location = location,
                days = days
            )
            _state.value = WeatherState(data = forecast)
        } catch (e: Exception) {
            _state.value = WeatherState(error = e.localizedMessage ?: "Unknown error")
        }
    }

    companion object {
        private const val LOCATION = "55.7569,37.6151"
        private const val DAYS = 3

    }

}