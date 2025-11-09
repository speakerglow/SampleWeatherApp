package com.example.sampleweatherapp.presentation.ui

import androidx.activity.compose.LocalActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.example.sampleweatherapp.presentation.navigation.Destination
import com.example.sampleweatherapp.presentation.navigation.NavGraph
import com.example.sampleweatherapp.presentation.viewModel.MainViewModel
import org.koin.androidx.compose.koinViewModel
import androidx.compose.runtime.collectAsState
import com.example.sampleweatherapp.presentation.presentationModels.WeatherIntent
import com.example.sampleweatherapp.presentation.ui.details.DetailsScreen
import com.example.sampleweatherapp.presentation.ui.forecast.ForecastScreen

@Composable
fun MainScreen() {
    val navHostController = rememberNavController()
    val activity = LocalActivity.current
    val viewModel: MainViewModel = koinViewModel()

    LaunchedEffect(Unit) {
        viewModel.sendIntent(WeatherIntent.LoadForecast())
    }

    NavGraph(navHostController = navHostController, forecastScreen = {
        ForecastScreen(viewModel = viewModel, onNavigateToDetails = { position ->
            navHostController.navigate(
                Destination.DetailsScreen.createRoute(position)
            )
        }, back = {
            activity?.finish()
        })

    }, detailsScreen = { position ->
        val hours =
            viewModel.state.collectAsState().value.data?.forecast?.forecastday[position!!]?.hour
        DetailsScreen(hours = hours) {
            navHostController.popBackStack()
        }
    })

}