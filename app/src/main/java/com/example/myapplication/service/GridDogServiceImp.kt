package com.example.myapplication.service

import com.example.myapplication.response.DogResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class GridDogServiceImp {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val serviceGrid = retrofit.create<GridDogService>()

    suspend fun getGridDogs(): Response<DogResponse> {
        return serviceGrid.getGridDogs()
    }
}
