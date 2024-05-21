package com.example.myapplication.service


import com.example.myapplication.response.SearchDogResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface SearchDogService {

    @GET("breed/{breed}/images/random")

    suspend fun getSearchDogs(@Path("breed") breed: String): Response<SearchDogResponse>

}