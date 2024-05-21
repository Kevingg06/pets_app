package com.example.myapplication.service

import com.example.myapplication.response.DogResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class DogServiceImp {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create<DogService>()

    suspend fun getDogs(): Response<DogResponse> {
        return service.getDogs()
    }
}
