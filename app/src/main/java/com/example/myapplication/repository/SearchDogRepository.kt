package com.example.myapplication.repository

import com.example.myapplication.response.DogResponse
import com.example.myapplication.response.RandomDogResponse
import com.example.myapplication.response.SearchDogResponse
import com.example.myapplication.service.DogServiceImp
import com.example.myapplication.service.RandomDogServiceImp
import com.example.myapplication.service.SearchDogServiceImp
import retrofit2.Response


class SearchDogRepository(private val service: SearchDogServiceImp = SearchDogServiceImp()) {
    suspend fun getSearchDogs(breed : String): Response<SearchDogResponse> {
        return service.getSearchDogs(breed)
    }
}