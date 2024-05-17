package com.example.myapplication.repository

import com.example.myapplication.response.DogResponse
import com.example.myapplication.service.DogServiceImp
import retrofit2.Response


class DogRepository(private val service: DogServiceImp = DogServiceImp()) {
    suspend fun getDogs(): Response<DogResponse> {
        return service.getDogs()
    }
}