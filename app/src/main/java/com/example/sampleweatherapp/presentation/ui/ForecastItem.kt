package com.example.sampleweatherapp.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
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
import com.example.sampleweatherapp.domain.ForecastDay

@Composable
fun ForecastItem(modifier: Modifier = Modifier, day: ForecastDay, onClick: () -> Unit) {

    Card(
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.onBackground,
                shape = RoundedCornerShape(20.dp)
            ),
        onClick = onClick
    ) {

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Text(
                    text = stringResource(R.string.date, day.date),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Text(
                    text = stringResource(R.string.temperaure, day.day.avgtemp_c),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                Text(
                    text = stringResource(R.string.precipitation, day.day.totalprecip_mm),
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }


            AsyncImage(
                model = "https:${day.day.condition.icon}",
                placeholder = painterResource(R.drawable.outline_broken_image_24),
                error = painterResource(R.drawable.outline_broken_image_24),
                fallback = painterResource(R.drawable.outline_broken_image_24),
                contentDescription = null,
                modifier = Modifier.size(32.dp),
            )
        }
    }
}
