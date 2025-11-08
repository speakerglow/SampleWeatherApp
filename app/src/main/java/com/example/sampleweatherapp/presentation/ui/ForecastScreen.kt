package com.example.sampleweatherapp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import com.example.sampleweatherapp.presentation.presentationModels.WeatherIntent
import com.example.sampleweatherapp.presentation.viewModel.MainViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ForecastScreen(viewModel: MainViewModel = getViewModel()) {

    val state = viewModel.state.collectAsState().value

    LaunchedEffect(Unit) {
        viewModel.sendIntent(WeatherIntent.LoadForecast())
    }

}