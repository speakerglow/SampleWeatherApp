package com.example.sampleweatherapp.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavGraph(
    navHostController: NavHostController,
    forecastScreen: @Composable () -> Unit,
    detailsScreen: @Composable () -> Unit
) {

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navHostController,
        startDestination = Destination.ForecastScreen.route
    ) {

        composable(route = Destination.ForecastScreen.route) {
            forecastScreen()
        }

        composable(route = Destination.DetailsScreen.route) {
            detailsScreen()
        }

    }

}