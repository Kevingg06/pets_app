package com.example.myapplication.repository

import com.example.myapplication.response.DogResponse
import com.example.myapplication.response.RandomDogResponse
import com.example.myapplication.service.DogServiceImp
import com.example.myapplication.service.RandomDogServiceImp
import retrofit2.Response


class RandomDogRepository(private val service: RandomDogServiceImp = RandomDogServiceImp()) {
    suspend fun getRandomDogs(): Response<RandomDogResponse> {
        return service.getRandomDogs()
    }
}