package com.example.sampleweatherapp.presentation.ui.details

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.sampleweatherapp.R
import com.example.sampleweatherapp.domain.Hour
import com.example.sampleweatherapp.presentation.presentationModels.WeatherIntent
import com.example.sampleweatherapp.presentation.ui.components.AppBar
import com.example.sampleweatherapp.presentation.ui.components.ErrorScreen
import com.example.sampleweatherapp.presentation.viewModel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel(),
    hours: List<Hour>?,
    back: () -> Unit
) {

    BackHandler(onBack = back)

    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.background)
            .systemBarsPadding()
    ) {
        AppBar(
            title = stringResource(R.string.forecast),
            onBack = back,
            modifier = Modifier.padding(horizontal = 24.dp)
        )


        if (hours == null) {
            ErrorScreen(
                message = stringResource(R.string.errorDefault),
                onRetry = {
                    viewModel.sendIntent(WeatherIntent.LoadForecast())
                })
        } else {

            LazyRow {

                items(hours!!.size, key = { hours[it].time_epoch }) { position ->

                    HourItem(
                        modifier = Modifier.padding(horizontal = 4.dp, vertical = 16.dp),
                        hour = hours[position]
                    )

                }
            }
        }
    }
}


//@Preview(showBackground = true)
//@Composable
//private fun DetailsScreen_preview() {
//    SampleWeatherAppTheme {
//
//        DetailsScreen { }
//
//    }
//}