package com.example.sampleweatherapp.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sampleweatherapp.presentation.presentationModels.WeatherIntent
import com.example.sampleweatherapp.presentation.theme.SampleWeatherAppTheme
import com.example.sampleweatherapp.presentation.viewModel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ForecastScreen(
    viewModel: MainViewModel = koinViewModel(),
    onNavigateToDetails: () -> Unit,
    back: () -> Unit
) {

    val state = viewModel.state.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.sendIntent(WeatherIntent.LoadForecast())
    }

    Column(modifier = Modifier.systemBarsPadding()) {

        AppBar(title = "Details", onBack = back)



    }
}

@Preview(showBackground = true)
@Composable
private fun ForecastScreen_preview() {
    SampleWeatherAppTheme {

        ForecastScreen(onNavigateToDetails = {}, back = {})

    }
}