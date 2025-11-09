package com.example.sampleweatherapp.presentation.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sampleweatherapp.R
import com.example.sampleweatherapp.presentation.theme.SampleWeatherAppTheme

@Composable
fun AppBar(
    modifier: Modifier = Modifier,
    title: String,
    onBack: () -> Unit,
    refresh: () -> Unit = {},
    refreshVisible: Boolean = false
) {

    Box(modifier = modifier.fillMaxWidth()) {
        IconButton(onClick = onBack) {
            Icon(
                Icons.Default.ArrowBack,
                contentDescription = null,
                modifier = Modifier.size(24.dp)
            )
        }

        Text(
            text = title,
            modifier = Modifier
                .align(Alignment.Center)
                .fillMaxWidth(),
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )

        if (refreshVisible) IconButton(
            onClick = refresh,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Icon(
                painter = painterResource(R.drawable.baseline_refresh_24),
                contentDescription = null,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
private fun AppBar_preview() {
    SampleWeatherAppTheme {

        AppBar(title = "title", onBack = {}, refreshVisible = true)

    }
}