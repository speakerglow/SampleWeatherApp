package com.example.sampleweatherapp.presentation.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.sampleweatherapp.presentation.viewModel.MainViewModel
import org.koin.androidx.compose.getViewModel

@Composable
fun ForecastScreen(viewModel: MainViewModel = getViewModel()) {


    Text(text = viewModel.foo(), modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)

}