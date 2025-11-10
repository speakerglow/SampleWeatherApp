package com.example.sampleweatherapp.presentation.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sampleweatherapp.R
import com.example.sampleweatherapp.domain.Hour

@Composable
fun HourItem(
    modifier: Modifier = Modifier,
    hour: Hour?,
    extendedInfo: Boolean = false,
    onClick: (Hour) -> Unit
) {

    if (hour == null) return

    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(contentColor = MaterialTheme.colorScheme.onBackground),
        shape = RoundedCornerShape(14.dp),
        onClick = {
            onClick(hour)
        }
    ) {

        Column(
            modifier = Modifier
                .padding(8.dp)
                .then(if (extendedInfo) Modifier.fillMaxWidth() else Modifier),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            AsyncImage(
                model = "https:${hour.condition.icon}",
                placeholder = painterResource(R.drawable.outline_broken_image_24),
                error = painterResource(R.drawable.outline_broken_image_24),
                fallback = painterResource(R.drawable.outline_broken_image_24),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .padding(vertical = 4.dp),
            )

            Text(
                text = stringResource(R.string.time, hour.time),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Text(
                text = stringResource(R.string.temperaure, hour.temp_c),
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            if (extendedInfo) {
                Text(
                    text = stringResource(R.string.humidity, hour.humidity),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(vertical = 4.dp)
                )

                Text(
                    text = stringResource(R.string.wind, hour.wind_kph),
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(vertical = 4.dp)
                )

                Text(
                    text = "Feels like ${hour.feelslike_c}",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            }
        }

    }
}