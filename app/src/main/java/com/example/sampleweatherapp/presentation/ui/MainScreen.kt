package com.example.sampleweatherapp.presentation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.sampleweatherapp.presentation.navigation.NavGraph

@Composable
fun MainScreen() {

    val navHostController = rememberNavController()
    NavGraph(navHostController = navHostController, forecastScreen = {
        ForecastScreen()
    }, detailsScreen = {
        DetailsScreen()
    })

}