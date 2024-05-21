package com.example.myapplication.viewModel

import com.example.myapplication.response.DogResponse

sealed class StateViewModel {
    data class Success( val info: DogResponse) : StateViewModel()
    data class Error( val message: String) : StateViewModel()
    data object Loading : StateViewModel()
}
