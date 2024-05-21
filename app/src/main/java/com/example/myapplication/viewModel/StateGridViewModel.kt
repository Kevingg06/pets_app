package com.example.myapplication.viewModel

import com.example.myapplication.response.DogResponse

open class StateGridViewModel {
    data class Success( val info: DogResponse) : StateGridViewModel()
    data class Error( val message: String) : StateGridViewModel()
    //data object loading : StateGridViewModel()
}
