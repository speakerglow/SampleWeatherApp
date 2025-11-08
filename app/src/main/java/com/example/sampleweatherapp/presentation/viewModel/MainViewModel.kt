package com.example.sampleweatherapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.example.sampleweatherapp.data.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel()