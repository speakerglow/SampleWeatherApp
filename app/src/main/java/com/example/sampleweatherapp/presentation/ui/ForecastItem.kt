package com.example.sampleweatherapp.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.sampleweatherapp.presentation.theme.Purple80
import com.example.sampleweatherapp.presentation.theme.SampleWeatherAppTheme

@Composable
fun ForecastItem(modifier: Modifier = Modifier) {

    Card(
        modifier = modifier.fillMaxWidth(),
        colors = CardColors(Purple80, Purple80, Purple80, Purple80)
    ) {

        Text(text =":cdsciujnsdncids" )

    }

}

@Preview(showBackground = true)
@Composable
private fun ForecastItem_preview() {
    SampleWeatherAppTheme {
        ForecastItem()
    }
}
