package com.example.sampleweatherapp.di

import com.example.sampleweatherapp.data.Repository
import com.example.sampleweatherapp.network.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    fun provideRepository(api: ApiService): Repository = Repository(api)

}