package com.example.myapplication.service

import com.example.myapplication.response.DogResponse
import com.example.myapplication.response.SearchDogResponse
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class SearchDogServiceImp {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service = retrofit.create<SearchDogService>()

    suspend fun getSearchDogs(breed: String): Response<SearchDogResponse> {
        return service.getSearchDogs(breed)
    }

}