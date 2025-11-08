package com.example.sampleweatherapp.di

import com.example.sampleweatherapp.data.Repository
import com.example.sampleweatherapp.presentation.viewModel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { Repository(get()) }
    viewModel { MainViewModel(get()) }
}