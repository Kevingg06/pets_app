package com.example.myapplication.viewModel

import com.example.myapplication.response.DogResponse

sealed class StateViewModel() {
    data class Success(private val info: DogResponse) : StateViewModel()
    data class Error(private val message: String) : StateViewModel()
    data object loading : StateViewModel()
}