package com.example.sampleweatherapp.presentation.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sampleweatherapp.R
import com.example.sampleweatherapp.domain.ForecastDay
import com.example.sampleweatherapp.presentation.presentationModels.WeatherIntent
import com.example.sampleweatherapp.presentation.theme.SampleWeatherAppTheme
import com.example.sampleweatherapp.presentation.viewModel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun ForecastScreen(
    viewModel: MainViewModel,
    onNavigateToDetails: (Int) -> Unit,
    back: () -> Unit
) {

    val state = viewModel.state.collectAsState()

    BackHandler(onBack = back)

    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding()
            .padding(horizontal = 24.dp)
    ) {

        AppBar(
            title = stringResource(R.string.forecast),
            onBack = back,
            refreshVisible = state.value.isLoading.not(),
            refresh = { viewModel.sendIntent(WeatherIntent.LoadForecast()) })

        Box(modifier = Modifier.fillMaxSize()) {

            when {
                state.value.error != null -> {
                    ErrorScreen(
                        message = state.value.error ?: stringResource(R.string.errorDefault),
                        onRetry = {
                            viewModel.sendIntent(WeatherIntent.LoadForecast())
                        })
                }

                state.value.isLoading -> {
                    LoadingScreen()
                }

                state.value.data != null -> {
                    LazyColumn {
                        items(state.value.data?.forecast?.forecastday?.size ?: 0) { item ->
                            ForecastItem(
                                modifier = Modifier.padding(vertical = 8.dp),
                                day = state.value.data?.forecast?.forecastday[item]!!,
                                onClick = { onNavigateToDetails(item) })
                        }
                    }
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun ForecastScreen_preview() {
//    SampleWeatherAppTheme {
//
//        ForecastScreen(onNavigateToDetails = {}, back = {})
//
//    }
//}