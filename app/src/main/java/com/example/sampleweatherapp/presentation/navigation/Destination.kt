package com.example.sampleweatherapp.presentation.navigation

sealed class Destination(val route: String) {

    object ForecastScreen : Destination(FORECAST_DESTINATION)

    object DetailsScreen : Destination(DAY_DETAILS_FORECAST_DESTINATION) {
        fun createRoute(position: Int) =
            DAY_DETAILS_FORECAST_DESTINATION.replace("{position}", position.toString())
    }


    companion object {

        private const val DAY_DETAILS_FORECAST_DESTINATION = "day_details_destination/{position}"
        private const val FORECAST_DESTINATION = "forecast_destination"

    }

}