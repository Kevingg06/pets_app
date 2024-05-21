package com.example.myapplication.viewModel

import com.example.myapplication.response.RandomDogResponse

open class StateRandomDogViewModel {
    data class Success( val info: RandomDogResponse) : StateRandomDogViewModel()
    data class Error( val message: String) : StateRandomDogViewModel()
}