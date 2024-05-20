package com.example.myapplication.repository

import com.example.myapplication.response.DogResponse
import com.example.myapplication.service.GridDogServiceImp
import retrofit2.Response

class GridDogRepository(private val service: GridDogServiceImp = GridDogServiceImp()) {
    suspend fun getGridDogs(): Response<DogResponse> {
        return service.getGridDogs()
    }
}