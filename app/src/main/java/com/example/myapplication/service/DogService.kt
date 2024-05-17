package com.example.myapplication.service

import com.example.myapplication.response.DogResponse
import retrofit2.Response
import retrofit2.http.GET

interface DogService {

    @GET("breeds/image/random/2")

    suspend fun getDogs(): Response<DogResponse>
}