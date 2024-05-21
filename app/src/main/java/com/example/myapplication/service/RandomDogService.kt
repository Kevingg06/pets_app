package com.example.myapplication.service

import com.example.myapplication.response.DogResponse
import com.example.myapplication.response.RandomDogResponse
import retrofit2.Response
import retrofit2.http.GET

interface RandomDogService {

    @GET("breeds/image/random")

    suspend fun getRandomDog(): Response<RandomDogResponse>
}
