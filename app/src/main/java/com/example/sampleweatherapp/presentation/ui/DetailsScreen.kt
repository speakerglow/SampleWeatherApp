package com.example.sampleweatherapp.presentation.ui

import androidx.activity.ComponentActivity
import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.sampleweatherapp.presentation.viewModel.MainViewModel

@Composable
fun DetailsScreen() {

    val sharedViewModel: MainViewModel = hiltViewModel(LocalActivity.current as ComponentActivity)


}