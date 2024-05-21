package com.example.myapplication.service

import com.example.myapplication.response.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface GridDogService {
    @GET("breeds/image/random/24")

    suspend fun getGridDogs(): Response<DogResponse>
}
