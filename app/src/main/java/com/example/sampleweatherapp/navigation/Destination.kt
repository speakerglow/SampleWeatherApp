package com.example.sampleweatherapp.navigation

sealed class Destination(val route: String) {

    object ForecastScreen : Destination(FORECAST_DESTINATION)

    object DetailsScreen: Destination(DAY_DETAILS_FORECAST_DESTINATION)


    companion object {

        private const val DAY_DETAILS_FORECAST_DESTINATION = "day_details_destination"
        private const val FORECAST_DESTINATION = "forecast_destination"

    }

}