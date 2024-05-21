package com.example.myapplication.viewModel

import com.example.myapplication.response.SearchDogResponse

open class StateSearchDogViewModel {
    data class Success( val info: SearchDogResponse) : StateSearchDogViewModel()
    data class Error( val message: String) : StateSearchDogViewModel()
    //data object loading : StateGridViewModel()
}
