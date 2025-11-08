package com.example.sampleweatherapp.di

import com.example.sampleweatherapp.data.Repository
import com.example.sampleweatherapp.presentation.viewModel.MainViewModel
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel

val appModule = module {

    single {
        Repository()
    }

    viewModel {
        MainViewModel(get())
    }

}