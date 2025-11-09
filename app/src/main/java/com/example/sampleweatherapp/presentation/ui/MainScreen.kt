package com.example.sampleweatherapp.presentation.ui

import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.sampleweatherapp.presentation.navigation.Destination
import com.example.sampleweatherapp.presentation.navigation.NavGraph

@Composable
fun MainScreen() {
    val navHostController = rememberNavController()
    val activity = LocalActivity.current
    NavGraph(navHostController = navHostController, forecastScreen = {
        ForecastScreen(onNavigateToDetails = {
            navHostController.navigate(Destination.DetailsScreen.route)
        }, back = {
            activity?.finish()
        })

    }, detailsScreen = { position ->
        DetailsScreen(position = position) {
            navHostController.popBackStack()
        }
    })

}