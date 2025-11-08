package com.example.sampleweatherapp.presentation.ui

import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sampleweatherapp.presentation.viewModel.MainViewModel

@Composable
fun ForecastScreen() {

    val sharedViewModel: MainViewModel = hiltViewModel(LocalActivity.current as ComponentActivity)

    Text(text = "tevcdlk;svcd", modifier = Modifier.fillMaxSize(), textAlign = TextAlign.Center)

}