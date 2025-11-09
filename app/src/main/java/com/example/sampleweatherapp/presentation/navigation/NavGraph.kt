package com.example.sampleweatherapp.presentation.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument

@Composable
fun NavGraph(
    navHostController: NavHostController,
    forecastScreen: @Composable () -> Unit,
    detailsScreen: @Composable (Int?) -> Unit
) {

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navHostController,
        startDestination = Destination.ForecastScreen.route
    ) {

        composable(route = Destination.ForecastScreen.route) {
            forecastScreen()
        }

        composable(
            route = Destination.DetailsScreen.route,
            arguments = listOf(navArgument("position") { type = NavType.IntType })
        ) { backStackEntry ->
            val position = backStackEntry.arguments?.getInt("position")
            detailsScreen(position)
        }
    }
}