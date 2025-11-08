package com.example.sampleweatherapp.presentation.ui

import androidx.compose.runtime.Composable
import com.example.sampleweatherapp.presentation.viewModel.MainViewModel
import org.koin.androidx.compose.koinViewModel
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sampleweatherapp.presentation.theme.SampleWeatherAppTheme

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = koinViewModel(),
    back: () -> Unit
) {

    BackHandler(onBack = back)

    Column(
        modifier = modifier
            .systemBarsPadding()
    ) {

        AppBar(title = "Details", onBack = back)
    }

}


@Preview(showBackground = true)
@Composable
private fun DetailsScreen_preview() {
    SampleWeatherAppTheme {

        DetailsScreen { }

    }
}